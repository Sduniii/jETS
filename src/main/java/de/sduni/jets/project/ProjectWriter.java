package de.sduni.jets.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import de.sduni.jets.model.v20.KNX;
import de.sduni.jets.model.v20.Project;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProjectWriter {

    private final XmlMapper xmlMapper;

    public ProjectWriter() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    }

    private static char[] deriveEtsPassword(char[] rawPassword) throws Exception {
        if (rawPassword == null || rawPassword.length == 0) return null;

        String passwordStr = new String(rawPassword);
        byte[] salt = "21.project.ets.knx.org".getBytes(StandardCharsets.US_ASCII);
        byte[] passBytes = passwordStr.getBytes(StandardCharsets.UTF_16LE);

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(passBytes, "HmacSHA256"));

        int keyLengthBytes = 32;
        int iterations = 65536;
        byte[] derivedKey = new byte[keyLengthBytes];
        int hashLen = mac.getMacLength();
        int blocks = (int) Math.ceil((double) keyLengthBytes / hashLen);

        byte[] currentBlock = new byte[salt.length + 4];
        System.arraycopy(salt, 0, currentBlock, 0, salt.length);

        int offset = 0;
        for (int i = 1; i <= blocks; i++) {
            currentBlock[salt.length] = (byte) ((i >> 24) & 0xff);
            currentBlock[salt.length + 1] = (byte) ((i >> 16) & 0xff);
            currentBlock[salt.length + 2] = (byte) ((i >> 8) & 0xff);
            currentBlock[salt.length + 3] = (byte) (i & 0xff);

            byte[] u = mac.doFinal(currentBlock);
            byte[] blockResult = u.clone();

            for (int j = 1; j < iterations; j++) {
                u = mac.doFinal(u);
                for (int k = 0; k < blockResult.length; k++) {
                    blockResult[k] ^= u[k];
                }
            }

            int len = Math.min(hashLen, derivedKey.length - offset);
            System.arraycopy(blockResult, 0, derivedKey, offset, len);
            offset += len;
        }

        String base64Key = Base64.getEncoder().encodeToString(derivedKey);
        return base64Key.toCharArray();
    }

    public void writeProject(KNX rootKnx, Path destination, char[] rawPassword) throws Exception {
        Files.deleteIfExists(destination);

        // 1. Prepare KNX_master.xml
        KNX masterKnx = new KNX();
        masterKnx.setCreatedBy(rootKnx.getCreatedBy());
        masterKnx.setToolVersion(rootKnx.getToolVersion());
        masterKnx.setMasterData(rootKnx.getMasterData());
        masterKnx.setManufacturerData(rootKnx.getManufacturerData());

        Path tempDir = Files.createTempDirectory("openets_save_");
        File masterFile = tempDir.resolve("knx_master.xml").toFile();
        xmlMapper.writeValue(masterFile, masterKnx);

        char[] derivedPassword = null;
        if (rawPassword != null && rawPassword.length > 0) {
            derivedPassword = deriveEtsPassword(rawPassword);
        }

        try (ZipFile outerZip = new ZipFile(destination.toFile())) {
            // Master file is never encrypted
            outerZip.addFile(masterFile);

            if (rootKnx.getProject() != null) {
                for (Project project : rootKnx.getProject()) {
                    String projectId = project.getId();
                    if (projectId == null || projectId.isEmpty()) {
                        projectId = "P-XXXX";
                    }

                    // 2. Prepare project.xml
                    KNX projectOnlyKnx = new KNX();
                    projectOnlyKnx.setCreatedBy(rootKnx.getCreatedBy());
                    projectOnlyKnx.setToolVersion(rootKnx.getToolVersion());
                    
                    Project projClone = new Project();
                    projClone.setId(project.getId());
                    projClone.setProjectInformation(project.getProjectInformation());
                    projClone.setUserFiles(project.getUserFiles());
                    projClone.setAddinData(project.getAddinData());
                    List<Project> pList = new ArrayList<>();
                    pList.add(projClone);
                    projectOnlyKnx.setProject(pList);

                    File projFile = tempDir.resolve("project.xml").toFile();
                    xmlMapper.writeValue(projFile, projectOnlyKnx);

                    // 3. Prepare 0.xml
                    KNX installOnlyKnx = new KNX();
                    installOnlyKnx.setCreatedBy(rootKnx.getCreatedBy());
                    installOnlyKnx.setToolVersion(rootKnx.getToolVersion());
                    
                    Project instClone = new Project();
                    instClone.setId(project.getId());
                    instClone.setInstallations(project.getInstallations());
                    List<Project> iList = new ArrayList<>();
                    iList.add(instClone);
                    installOnlyKnx.setProject(iList);

                    File installFile = tempDir.resolve("0.xml").toFile();
                    xmlMapper.writeValue(installFile, installOnlyKnx);

                    // Create inner zip P-XXXX.zip
                    File innerZipFile = tempDir.resolve(projectId + ".zip").toFile();
                    try (ZipFile innerZip = new ZipFile(innerZipFile)) {
                        ZipParameters zipParams = new ZipParameters();
                        zipParams.setCompressionMethod(CompressionMethod.DEFLATE);
                        if (derivedPassword != null) {
                            innerZip.setPassword(derivedPassword);
                            zipParams.setEncryptFiles(true);
                            zipParams.setEncryptionMethod(EncryptionMethod.AES);
                            zipParams.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
                        }
                        
                        // Add inside a directory named after the project ID
                        zipParams.setRootFolderNameInZip(projectId);
                        innerZip.addFile(projFile, zipParams);
                        innerZip.addFile(installFile, zipParams);
                    }

                    // Add inner zip to outer zip
                    outerZip.addFile(innerZipFile);
                }
            }
        } finally {
            // Cleanup temp dir
            Files.walk(tempDir)
                 .map(Path::toFile)
                 .forEach(File::delete);
            tempDir.toFile().delete();
        }
    }
}
