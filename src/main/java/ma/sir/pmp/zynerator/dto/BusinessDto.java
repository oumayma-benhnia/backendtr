package ma.sir.pmp.zynerator.dto;

import java.io.Serializable;

public class BusinessDto implements Serializable {

    private Long id;

    private String label;

    public BusinessDto() {

    }

    public BusinessDto(Long id, String label) {

        this.id = id;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {

        return this.getId() != null ? this.getId().toString() : null;
    }

}
