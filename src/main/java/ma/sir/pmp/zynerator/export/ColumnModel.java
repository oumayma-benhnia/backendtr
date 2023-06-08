package ma.sir.pmp.zynerator.export;

import java.io.Serializable;

public class ColumnModel implements Serializable {

    private String name;
    private String label;
    private String format;

    public ColumnModel() {

    }

    public ColumnModel(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}