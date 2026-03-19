package de.sduni.jets.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import de.sduni.jets.model.v20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;

public class ProjectReader {
    private static final Logger logger = LoggerFactory.getLogger(ProjectReader.class);
    private final XmlMapper xmlMapper;

    public static class EncryptedProjectException extends Exception {
        public EncryptedProjectException(String message) { super(message); }
    }

    public ProjectReader() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    private static char[] deriveEtsPassword(char[] rawPassword) throws Exception {
        if (rawPassword == null || rawPassword.length == 0) return null;
        String passwordStr = new String(rawPassword);
        byte[] salt = "21.project.ets.knx.org".getBytes(StandardCharsets.US_ASCII);
        byte[] passBytes = passwordStr.getBytes(StandardCharsets.UTF_16LE);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(passBytes, "HmacSHA256"));
        byte[] derivedKey = new byte[32];
        byte[] currentBlock = new byte[salt.length + 4];
        System.arraycopy(salt, 0, currentBlock, 0, salt.length);
        currentBlock[salt.length + 3] = 1;
        byte[] u = mac.doFinal(currentBlock);
        byte[] blockResult = u.clone();
        for (int j = 1; j < 65536; j++) {
            u = mac.doFinal(u);
            for (int k = 0; k < blockResult.length; k++) blockResult[k] ^= u[k];
        }
        System.arraycopy(blockResult, 0, derivedKey, 0, 32);
        return Base64.getEncoder().encodeToString(derivedKey).toCharArray();
    }

    public KNX readProject(Path knxprojPath) throws Exception { return readProject(knxprojPath, null); }

    public KNX readProject(Path knxprojPath, char[] rawPassword) throws Exception {
        KNX rootKnx = new KNX();
        char[] derivedPassword = (rawPassword != null) ? deriveEtsPassword(rawPassword) : null;

        try (ZipFile zipFile = new ZipFile(knxprojPath.toFile())) {
            if (derivedPassword != null) zipFile.setPassword(derivedPassword);
            else if (zipFile.isEncrypted()) throw new EncryptedProjectException("Project is encrypted.");

            for (FileHeader entry : zipFile.getFileHeaders()) {
                String name = entry.getFileName();
                if (name.equals("knx_master.xml") || (name.startsWith("M-") && name.endsWith(".xml"))) {
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        mergeManufacturerData(rootKnx, xmlMapper.readValue(is, KNX.class));
                    } catch (Exception e) {
                        if (e.getMessage() != null && e.getMessage().contains("password") && derivedPassword == null)
                            throw new EncryptedProjectException("Manufacturer data is encrypted.");
                        logger.debug("Skipping file {}: {}", name, e.getMessage());
                    }
                }

                if (name.startsWith("P-") && name.endsWith(".zip")) {
                    Path temp = Files.createTempFile("jets_inner_", ".zip");
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        Files.copy(is, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                        try (ZipFile innerZip = new ZipFile(temp.toFile())) {
                            if (derivedPassword != null) innerZip.setPassword(derivedPassword);
                            else if (innerZip.isEncrypted()) throw new EncryptedProjectException("Inner project is encrypted.");
                            
                            for (FileHeader ie : innerZip.getFileHeaders()) {
                                String iname = ie.getFileName();
                                if (iname.endsWith("project.xml") || iname.endsWith("0.xml")) {
                                    try (InputStream iis = innerZip.getInputStream(ie)) {
                                        mergeKnxData(rootKnx, xmlMapper.readValue(iis, KNX.class));
                                    } catch (Exception e) {
                                        logger.warn("Could not read inner file {}: {}", iname, e.getMessage());
                                    }
                                }
                            }
                        }
                    } finally { Files.deleteIfExists(temp); }
                }
            }
        }
        return rootKnx;
    }

    private void mergeManufacturerData(KNX root, KNX source) {
        if (source == null || source.getManufacturerData() == null) return;
        if (root.getManufacturerData() == null) {
            root.setManufacturerData(source.getManufacturerData());
            return;
        }
        List<ManufacturerData_Manufacturer> rList = root.getManufacturerData().getManufacturer();
        List<ManufacturerData_Manufacturer> sList = source.getManufacturerData().getManufacturer();
        if (sList != null) {
            for (ManufacturerData_Manufacturer sm : sList) {
                if (rList.stream().noneMatch(rm -> sm.getRefId() != null && sm.getRefId().equals(rm.getRefId()))) {
                    rList.add(sm);
                }
            }
        }
    }

    private void mergeKnxData(KNX root, KNX source) {
        if (source == null || source.getProject() == null) return;
        if (root.getProject() == null) {
            root.setProject(new ArrayList<>(source.getProject()));
            return;
        }

        for (Project sProj : source.getProject()) {
            Project rProj = root.getProject().stream().filter(p -> p.getId().equals(sProj.getId())).findFirst().orElse(null);
            if (rProj == null) {
                root.getProject().add(sProj);
            } else {
                if (sProj.getInstallations() != null && !sProj.getInstallations().getInstallation().isEmpty()) {
                    if (rProj.getInstallations() == null) {
                        rProj.setInstallations(sProj.getInstallations());
                    } else {
                        // Merge the first installation (usually only one)
                        Project_Installations_Installation rInst = rProj.getInstallations().getInstallation().get(0);
                        Project_Installations_Installation sInst = sProj.getInstallations().getInstallation().get(0);
                        if (sInst.getTopology() != null) rInst.setTopology(sInst.getTopology());
                        if (sInst.getLocations() != null) rInst.setLocations(sInst.getLocations());
                        if (sInst.getGroupAddresses() != null) rInst.setGroupAddresses(sInst.getGroupAddresses());
                    }
                }
            }
        }
    }
}
