package ma.sir.pmp.zynerator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NumberUtil {
    private NumberUtil() {
    }

    public static boolean isPostif(Long number) {
        return number != null && number > 0;
    }

    public static boolean isInteger(String value) {
        try {
            return Integer.valueOf(value) != null;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(String value) {
        try {
            return Long.valueOf(value) != null;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(Object value) {
        try {
            return Long.valueOf(String.valueOf(value)) != null;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String value) {
        try {
            Double d = Double.parseDouble(value);
            if (d.isInfinite())
                return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static double formatDecimal(double d) {

        String dd = String.valueOf(d);
        try {
            BigDecimal decimalFormat = new BigDecimal(dd);
            decimalFormat = decimalFormat.setScale(2, RoundingMode.HALF_UP);
            return decimalFormat.doubleValue();
        } catch (Exception e) {
        }

        return d;
    }

    public static BigDecimal sum(Double d1, Double d2) {
        return new BigDecimal(d1.toString()).add(new BigDecimal(d2.toString()));
    }

    public static BigDecimal divide(Double d1, Double d2) {
        try {
            return new BigDecimal(d1.toString()).divide(new BigDecimal(d2.toString()), 2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("common.error.function.divide");
        }
    }

    public static BigDecimal multiply(Double d1, Double d2) {
        return new BigDecimal(d1.toString()).multiply(new BigDecimal(d2.toString()));
    }

    public static BigDecimal subtract(Double d1, Double d2) {
        return new BigDecimal(d1.toString()).subtract(new BigDecimal(d2.toString()));
    }

    public static boolean isSqlDouble(int val) {
        return val == Types.NUMERIC || val == Types.INTEGER || val == Types.DECIMAL || val == Types.DOUBLE
                || val == Types.BIGINT || val == Types.SMALLINT;
    }


    public static String chiffreToLettre(String s) {
        String toLettre = "";
        if (isInteger(s)) {
            toLettre = FrenchNumberToWords.convert(Integer.parseInt(s));
        }
        return toLettre;
    }


    public static String formatDecimalToString(double d) {
        try {
            return new DecimalFormat("##0.00").format(d).replaceAll(",", ".");
        } catch (Exception e) {
            return "0.00";
        }
    }

    public static String[] decomposerDecimal(Double b) {
        String[] tab = new String[2];
        String s = formatDecimalToString(b);
        if (s.indexOf(".") != -1) {
            tab = s.split("\\.");
        } else {
            tab[0] = s;
            tab[1] = "0";
        }
        return tab;
    }

    public static List<Long> getIdToList(Long id) {
        List<Long> result = new ArrayList<Long>();
        if (id != null)
            result.add(id);
        return result;
    }

}
