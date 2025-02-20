import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

public class Elgamal {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024, new SecureRandom());
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        Signature sig = Signature.getInstance("SHA1withDSA");
        sig.initSign(privateKey);

        String message = "This is a secret message";
        sig.update(message.getBytes());
        byte[] signatureBytes = sig.sign();
        System.out.println("Chữ kí: " + new BigInteger(1, signatureBytes).toString(16));

        sig.initVerify(publicKey);
        sig.update(message.getBytes());
        boolean verified = sig.verify(signatureBytes);
        System.out.println("Xác minh: " + verified);
    }
}
