package ma.sir.pmp.zynerator.util;

import java.util.Collection;

public class BooleanUtil {
    public static boolean isaBoolean(Object value1) {
        return value1 != null && value1 instanceof Collection<?>;
    }

    public static boolean isaBoolean(Object value1, Object value2) {
        return isaBoolean(value1) || isaBoolean(value2);
    }

    public static String getOuiOuNon(Object value1) {
        return Boolean.valueOf(String.valueOf(value1)) ? "OUI" : "NON";
    }

    public static boolean isNotEquals(Object value1, Object value2) {
        return (value2 != null && !value2.equals(value1)) || (value1 != null && !value1.equals(value2));
    }
}
