package ma.sir.pmp.zynerator.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.equals("null");
    }

    public static boolean isEmpty(String[] value) {
        return value == null || value.length == 0;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }


    public static boolean isEmpty(Long value) {
        return value == null;
    }

    public static boolean isNotEmpty(Long value) {
        return !isEmpty(value);
    }

    public static boolean isEmpty(Integer value) {
        return value == null;
    }

    public static boolean isNotEmpty(Integer value) {
        return !isEmpty(value);
    }

    public static boolean isEmpty(BigDecimal value) {
         return value == null;
    }

    public static boolean isNotEmpty(BigDecimal value) {
        return !isEmpty(value);
    }
    public static boolean isEmpty(Boolean value) {
        return value == null;
    }

    public static boolean isNotEmpty(Boolean value) {
        return !isEmpty(value);
    }

    public static boolean isNotEmpty(String[] value) {
        return !isEmpty(value);
    }

    public static boolean isNoEmpty(String[] array) {
        return (array != null && array.length > 0);
    }

    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean composed(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.')
                return true;
        }
        return false;
    }

    public static String listToString(List<String> list) {
        String s = "";
        if (list != null) {
            for (String string : list) {
                s = s + string + ";";
            }
        }
        return s;
    }

    public static Long[] listStringToArray(List<String> list) {
        Long[] ids = {};
        if (list != null && !list.isEmpty()) {
            ids = new Long[list.size()];
            int i = 0;
            for (String id : list) {
                ids[i] = Long.valueOf(id);
                i++;
            }
        }
        return ids;
    }
}
