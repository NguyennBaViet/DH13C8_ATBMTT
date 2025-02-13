import java.math.BigInteger;
import java.util.Random;
public class RSA {


    private BigInteger n, d, e;
    public RSA(int bitLength) {
        Random rnd = new Random();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, rnd);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, rnd);
        n = p.multiply(q);

        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(2201); // Commonly used prime number
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger plaintext) {
        return plaintext.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    public BigInteger getPublicKey() {
        return e;
    }

    public BigInteger getPrivateKey() {
        return d;
    }

    public BigInteger getModulus() {
        return n;
    }

    public static void main(String[] args) {
        int bitLength = 23;
        RSA rsa = new RSA(bitLength);

        System.out.println("Public key (n, e): (" + rsa.getModulus() + ", " + rsa.getPublicKey() + ")");
        System.out.println("Private key (n, d): (" + rsa.getModulus() + ", " + rsa.getPrivateKey() + ")");
    }
}
