package de.sduni.jets.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

public class WorkspaceManager {

    private final ObjectMapper mapper;

    public WorkspaceManager() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void saveWorkspace(JetsWorkspace workspace, Path path, char[] password) throws Exception {
        File tempJson = File.createTempFile("workspace", ".json");
        mapper.writeValue(tempJson, workspace);

        try (ZipFile zipFile = new ZipFile(path.toFile())) {
            if (password != null && password.length > 0) {
                zipFile.setPassword(password);
            }
            ZipParameters params = new ZipParameters();
            params.setEncryptFiles(password != null && password.length > 0);
            params.setEncryptionMethod(EncryptionMethod.AES);
            params.setFileNameInZip("workspace.json");
            zipFile.addFile(tempJson, params);
        }
        tempJson.delete();
    }

    public JetsWorkspace loadWorkspace(Path path, char[] password) throws Exception {
        try (ZipFile zipFile = new ZipFile(path.toFile())) {
            if (zipFile.isEncrypted() && password != null) {
                zipFile.setPassword(password);
            }
            FileHeader header = zipFile.getFileHeader("workspace.json");
            if (header == null) throw new IllegalArgumentException("Invalid workspace file");
            
            try (InputStream is = zipFile.getInputStream(header)) {
                return mapper.readValue(is, JetsWorkspace.class);
            }
        }
    }
}
