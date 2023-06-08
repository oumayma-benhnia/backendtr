package ma.sir.pmp.zynerator.util;

import java.io.Serializable;

public class MyDate implements Serializable {

    private Long date;

    private String locale;

    private String timeZone;

    public MyDate(Long date, String locale, String timeZone) {

        this.date = date;
        this.locale = locale;
        this.timeZone = timeZone;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
