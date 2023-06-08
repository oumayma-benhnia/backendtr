package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.exception.BusinessRuleException;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    // public static final String DATE_FORMAT_WITH_HOUR = "MM/dd/yyyy HH:mm";
    public static final String DATE_FORMAT_WITH_HOUR = "MM/dd/yyyy HH:mm";
    public static final String DATE_FORMAT_NAME = "ddMMyyyyHHmmss";
    public final static String DATE_FORMAT_FILE = "yyMMddHHmmss";
    public static final String HOUR_FORMAT = "HH:mm:ss";
    public static final String DATE_FORMAT_ENG = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_FORMAT_PF = "EEE MMM dd HH:mm:ss z yyyy";
    public static final long ONE_HOUR = 60 * 60 * 1000L;


    public static Calendar dateToCalendar(final Date date) {
        if (date != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            return cal;
        }
        return null;
    }

    public static LocalDateTime addDaysToDate(LocalDateTime date, long days) {
        if (date != null)
            return date.plusDays(days);
        return null;
    }

    public static long daysBetween(Date d1, Date d2) {
        return ((d2.getTime() - d1.getTime() + ONE_HOUR) / (ONE_HOUR * 24));
    }

    public static LocalDateTime stringEnToDate(final String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_ENG, Locale.ENGLISH);
        return LocalDateTime.parse(strDate, formatter);

    }

    public static String getCurrentDate() {
        return dateToString(LocalDate.now());
    }

    public static String getCurrentDateTime() {
        return dateTimeToString(LocalDateTime.now());
    }

    public static LocalDate stringToDate(final String strDate) {
        if (StringUtils.hasLength(strDate)) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
                return LocalDate.parse(strDate, formatter);

            } catch (Exception e) {
                throw new BusinessRuleException("errors.format.date");
            }
        }

        return null;
    }

    public static LocalDateTime stringTextToDate(final String strDate) {
        if (StringUtils.hasLength(strDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PF, Locale.US);
            return LocalDateTime.parse(strDate, formatter);
        }

        return null;
    }

    public static LocalDateTime stringToDateTime(final String strDate) {
        try {
            if (StringUtils.hasLength(strDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR);
                return LocalDateTime.parse(strDate, formatter);
            }
        } catch (Exception e) {
            throw new BusinessRuleException("errors.format.datetime");
        }

        return null;
    }

    public static Timestamp stringToTimestamp(final String strDate) {
        if (StringUtils.hasLength(strDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
            return new Timestamp(
                    LocalDateTime.parse(strDate, formatter).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        }
        return null;
    }

    public static String dateFormatFichier() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_FILE);
        return LocalDateTime.now().format(formatter);
    }

    public static Long stringToLongTime(final String strDate) {
        if (StringUtils.hasLength(strDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
            return LocalDateTime.parse(strDate, formatter).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }
        return null;
    }

    public static String dateToString(final LocalDate date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
            return date.format(formatter);
        }
        return "";
    }

    public static String dateToString(final LocalDateTime date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
            return date.format(formatter);
        }
        return "";
    }

/*
    public static String dateTimeToString(final LocalDateTime date) {
        try {
            if (date != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR);
                return date.format(formatter);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
*/
    public static String dateTimeToString(final LocalDateTime date) {
        try {
            if (date != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR,Locale.ENGLISH);
                OffsetDateTime off = OffsetDateTime.of(date, ZoneOffset.UTC);
                ZonedDateTime zoned = off.atZoneSameInstant(ZoneId.of("UTC+1"));
                return zoned.toLocalDateTime().format(formatter);
            }
        } catch (Exception e) {
        return null;
        }
    return null;
    }
    public static String dateTimeToString(final LocalDate date) {
        try {
            if (date != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR);
                return date.format(formatter);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static String dateToStringWithHour(final LocalDateTime date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR);
            return date.format(formatter);
        }
        return "";
    }

    public static String dateToStringWithHour(final Long d) {
        if (d != null && d != 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_WITH_HOUR);
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d), ZoneId.systemDefault());
            return date.format(formatter);
        }
        return "";
    }

    public static String timesTimpToStringWithHour(final Timestamp d) {
        if (d != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d.getTime()), ZoneId.systemDefault());
            return date.format(formatter);
        }
        return "";
    }

    public static String timesTimpToStringWithHour(final Long d) {
        if (d != null) {
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            return date.format(formatter);
        }
        return "";
    }

    public static String timesTimpToStringWithHourName(final Timestamp d) {
        if (d != null) {
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d.getTime()), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_NAME);
            return date.format(formatter);
        }
        return "";
    }

    public static String timesTimpToHour(final Timestamp d) {
        if (d != null) {
            LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d.getTime()), ZoneId.systemDefault());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HOUR_FORMAT);
            return date.format(formatter);
        }
        return "";
    }

    public static Timestamp StringToTimesTimpWithHour(final String date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
            return new Timestamp(
                    LocalDateTime.parse(date, formatter).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        }
        return null;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public static String addFrequence(String dateSouhaiteDebutTraitement, int i, String code) {
        LocalDateTime dateSouhaiteDebutTraitementDateTime = stringToDateTime(dateSouhaiteDebutTraitement);
        LocalDateTime myLocalDateTime = null;
        String result = null;
        if ("heure".equals(code)) {
            myLocalDateTime = dateSouhaiteDebutTraitementDateTime.plusHours(i);
        } else if ("jour".equals(code)) {
            myLocalDateTime = dateSouhaiteDebutTraitementDateTime.plusDays(i);
        } else if ("semaine".equals(code)) {
            myLocalDateTime = dateSouhaiteDebutTraitementDateTime.plusWeeks(i);
        } else if ("mois".equals(code)) {
            myLocalDateTime = dateSouhaiteDebutTraitementDateTime.plusMonths(i);
        }
        if (myLocalDateTime != null) {
            result = dateToStringWithHour(myLocalDateTime);
        }
        return result;
    }

    public static boolean isBeforeNow(String dateSouhaiteDebutTraitement) {
        LocalDateTime dateSouhaiteDebutTraitementDateTime = stringToDateTime(dateSouhaiteDebutTraitement);
        return dateSouhaiteDebutTraitementDateTime.isBefore(LocalDateTime.now());
    }
}
