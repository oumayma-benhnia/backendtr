package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class FournisseurDto  extends AuditBaseDto {

    private String code  ;
    private String nom  ;
    private String prenom  ;
    private String email  ;
    private String tele  ;
    private String societe  ;
    private String adresse  ;




    public FournisseurDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getTele(){
        return this.tele;
    }
    public void setTele(String tele){
        this.tele = tele;
    }

    @Log
    public String getSociete(){
        return this.societe;
    }
    public void setSociete(String societe){
        this.societe = societe;
    }

    @Log
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }






}
