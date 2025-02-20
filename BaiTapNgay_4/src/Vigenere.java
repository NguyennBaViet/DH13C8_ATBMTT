public class Vigenere {
    static String maHoa(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    static String giaiMa(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    public static void main(String[] args) {
        String key = "VietNam";
        String message = "HELLO WORLD";
        String encrypted = maHoa(message, key);
        String decrypted = giaiMa(encrypted, key);
        System.out.println("Nguyên bản: " + message);
        System.out.println("Dãy mã hóa: " + encrypted);
        System.out.println("Dãy giải mã: " + decrypted);
    }
}
