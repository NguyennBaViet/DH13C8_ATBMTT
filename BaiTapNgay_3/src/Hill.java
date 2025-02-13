    import java.util.Scanner;
public class Hill {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập dãy chữ: ");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        int[][] key = {{6, 24}, {1, 16}};

        String ciphertext = encrypt(plaintext, key);
        System.out.println("Dãy mã hóa: " + ciphertext);
    }

    public static String encrypt(String plaintext, int[][] key) {
        int n = key.length;
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += n) {
            int[] block = new int[n];
            for (int j = 0; j < n; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }

            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += key[j][k] * block[k];
                }
                ciphertext.append((char) ((sum % 26) + 'A'));
            }
        }

        return ciphertext.toString();
    }
}
