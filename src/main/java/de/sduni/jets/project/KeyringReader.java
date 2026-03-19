package de.sduni.jets.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import de.sduni.jets.model.secure.KnxKeyring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class KeyringReader {
    private static final Logger logger = LoggerFactory.getLogger(KeyringReader.class);
    private final XmlMapper xmlMapper;

    public KeyringReader() {
        xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public KnxKeyring readKeyring(Path path, char[] password) throws Exception {
        KnxKeyring keyring = null;
        
        // Detect if it's a ZIP or XML
        byte[] head = new byte[4];
        try (InputStream is = Files.newInputStream(path)) {
            is.read(head);
        }
        
        boolean isZip = (head[0] == 0x50 && head[1] == 0x4B); // PK signature

        if (isZip) {
            logger.info("Keyring detected as ZIP archive.");
            try (ZipFile zipFile = new ZipFile(path.toFile())) {
                if (zipFile.isEncrypted() && password != null) zipFile.setPassword(password);
                FileHeader header = zipFile.getFileHeader("keyring.xml");
                if (header != null) {
                    try (InputStream is = zipFile.getInputStream(header)) {
                        keyring = xmlMapper.readValue(is, KnxKeyring.class);
                    }
                }
            }
        } else {
            logger.info("Keyring detected as plain XML.");
            keyring = xmlMapper.readValue(path.toFile(), KnxKeyring.class);
        }

        if (keyring == null) throw new IllegalArgumentException("Could not parse keyring content");
        if (password != null && password.length > 0) decryptKeyring(keyring, password);
        return keyring;
    }

    private void decryptKeyring(KnxKeyring keyring, char[] password) throws Exception {
        byte[] hashedPass = hashKeyringPassword(password);
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] iv = Arrays.copyOf(sha256.digest(keyring.getCreated().getBytes(StandardCharsets.UTF_8)), 16);

        if (keyring.getInterfaces() != null) {
            for (KnxKeyring.Interface iface : keyring.getInterfaces()) {
                iface.password = decryptAndExtract(iface.password, hashedPass, iv);
                iface.authentication = decryptAndExtract(iface.authentication, hashedPass, iv);
            }
        }
        if (keyring.getDevices() != null && keyring.getDevices().deviceList != null) {
            for (KnxKeyring.Device device : keyring.getDevices().deviceList) {
                device.fdsk = decryptAndExtract(device.fdsk, hashedPass, iv);
                device.authentication = decryptAndExtract(device.authentication, hashedPass, iv);
            }
        }
    }

    private String decryptAndExtract(String b64Value, byte[] key, byte[] iv) {
        if (b64Value == null || b64Value.isEmpty()) return b64Value;
        try {
            byte[] encryptedData = Base64.getDecoder().decode(b64Value);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] decryptedRaw = cipher.doFinal(encryptedData);

            int footerLength = decryptedRaw[decryptedRaw.length - 1] & 0xFF;
            if (footerLength + 8 > decryptedRaw.length) {
                byte[] raw = Arrays.copyOfRange(decryptedRaw, 8, Math.min(24, decryptedRaw.length));
                return bytesToHex(raw);
            }

            byte[] actualBytes = Arrays.copyOfRange(decryptedRaw, 8, decryptedRaw.length - footerLength);
            boolean isText = true;
            for (byte b : actualBytes) { if (b < 32 && b != 9 && b != 10 && b != 13) { isText = false; break; } }
            
            if (isText && actualBytes.length > 0) return new String(actualBytes, StandardCharsets.UTF_8);
            return bytesToHex(actualBytes);
        } catch (Exception e) { return b64Value; }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(String.format("%02X", b));
        return sb.toString();
    }

    private byte[] hashKeyringPassword(char[] password) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] salt = "1.keyring.ets.knx.org".getBytes(StandardCharsets.US_ASCII);
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
        return factory.generateSecret(spec).getEncoded();
    }
}
