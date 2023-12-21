package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import javax.persistence.Column;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeVenteDto extends AuditBaseDto {
    private String code;

    private String libelle;
    public TypeVenteDto(){
        super();
    }
@Log
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
@Log
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
