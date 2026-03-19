import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Pbkdf2Test {

    public static byte[] pbkdf2Sha256Utf16Le(String password, String saltStr, int iterations, int keyLengthBytes) throws Exception {
        byte[] salt = saltStr.getBytes(StandardCharsets.US_ASCII);
        byte[] passBytes = password.getBytes(StandardCharsets.UTF_16LE);

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(passBytes, "HmacSHA256"));

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

        return derivedKey;
    }

    public static void main(String[] args) throws Exception {
        String pass = "test";
        byte[] key = pbkdf2Sha256Utf16Le(pass, "21.project.ets.knx.org", 65536, 32);
        String b64 = Base64.getEncoder().encodeToString(key);
        System.out.println("Base64 derived password for 'test': " + b64);
    }
}
