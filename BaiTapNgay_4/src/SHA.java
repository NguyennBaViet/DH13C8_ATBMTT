import java.security.*;
public class SHA {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "This is a message";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());
        byte[] digest = md.digest();
        System.out.println("SHA-256 Hash: " + bytesToHex(digest));
    }
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
