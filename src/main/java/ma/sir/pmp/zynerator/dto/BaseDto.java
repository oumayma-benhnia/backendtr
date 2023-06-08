package ma.sir.pmp.zynerator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class BaseDto implements Serializable {

    protected Long id;
    protected String label;
    protected EtablissementDto etablissementDto;
    protected int maxLevel = 2;

    /**
     * Constructeur par défaut.
     */
    public BaseDto() {
    }

    public BaseDto(Long id) {
        this.id = id;
    }

    public EtablissementDto getEtablissementDto() {
        return etablissementDto;
    }

    public void setEtablissementDto(EtablissementDto etablissementDto) {
        this.etablissementDto = etablissementDto;
    }

    @Override
    public boolean equals(Object object) {
        if (this.id != null && object instanceof BaseDto) {
            BaseDto dto = (BaseDto) object;
            return this.id.equals(dto.getId());
        }
        return false;

    }

    /**
     * Méthode hashCode.
     *
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        Serializable pk = id;
        if (pk == null) {
            return 0;
        }
        return pk.toString().hashCode();
    }

    @JsonIgnore
    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
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
