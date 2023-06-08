package ma.sir.pmp.zynerator.util;

import ma.sir.pmp.zynerator.enumeration.BIRT_EXPORT_FORMAT;

import java.io.Serializable;
import java.util.List;

public class BirtWarpper implements Serializable {


    private String reportName;
    private BIRT_EXPORT_FORMAT format;
    private String prefix;
    private List<BirtMap> birtMap;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public BIRT_EXPORT_FORMAT getFormat() {
        return format;
    }

    public void setFormat(BIRT_EXPORT_FORMAT format) {
        this.format = format;
    }

    public List<BirtMap> getBirtMap() {
        return birtMap;
    }

    public void setBirtMap(List<BirtMap> birtMap) {
        this.birtMap = birtMap;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
