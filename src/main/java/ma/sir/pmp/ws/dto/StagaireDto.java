package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import javax.persistence.Column;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StagaireDto extends AuditBaseDto {
    private String code;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    private String fonction;


    public StagaireDto(){
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
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
@Log
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
@Log
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Log
    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
@Log
    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
