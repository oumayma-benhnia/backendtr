package ma.sir.pmp.zynerator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditBaseDtoEnhanced extends AuditBaseDto {

    protected Boolean actif = false;
    protected String hl7;
    protected Long ordre ;

    public Boolean getActif() {
    return actif;
    }

    public void setActif(Boolean actif) {
    this.actif = actif;
    }

    public String getHl7() {
    return hl7;
    }

    public void setHl7(String hl7) {
    this.hl7 = hl7;
    }

    public Long getOrdre() {
    return ordre;
    }

    public void setOrdre(Long ordre) {
    this.ordre = ordre;
    }
}