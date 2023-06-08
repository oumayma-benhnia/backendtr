package ma.sir.pmp.zynerator.util;

public class TranslateUtil {

    private TranslateUtil() {
    }

    public static String translate(String src) {
        StringBuilder result = new StringBuilder();
        if (src != null && src.length() != 0) {
            int index = -1;
            String chars = "àâäéèêëîïôöùûüç";
            String replace = "aaaeeeeiioouuuc";
            for (int i = 0; i < src.length(); i++) {
                if ((index = chars.indexOf(src.charAt(i))) != -1)
                    result.append(replace.charAt(index));
                else
                    result.append(src.charAt(i));
            }
        }
        return result.toString();
    }
}
