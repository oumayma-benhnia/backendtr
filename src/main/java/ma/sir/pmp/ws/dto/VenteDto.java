package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import javax.persistence.Column;
import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteDto extends AuditBaseDto {
    private String code;
    private String libelle;
    private TypeVenteDto typeVente ;
    private String dateVente ;
    private ClientDto client;
    public VenteDto(){
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

    public TypeVenteDto getTypeVente() {
        return typeVente;
    }

    public void setTypeVente(TypeVenteDto typeVente) {
        this.typeVente = typeVente;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
