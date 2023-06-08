package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FournisseurCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String email;
    private String emailLike;
    private String tele;
    private String teleLike;
    private String societe;
    private String societeLike;
    private String adresse;
    private String adresseLike;



    public FournisseurCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getTele(){
        return this.tele;
    }
    public void setTele(String tele){
        this.tele = tele;
    }
    public String getTeleLike(){
        return this.teleLike;
    }
    public void setTeleLike(String teleLike){
        this.teleLike = teleLike;
    }

    public String getSociete(){
        return this.societe;
    }
    public void setSociete(String societe){
        this.societe = societe;
    }
    public String getSocieteLike(){
        return this.societeLike;
    }
    public void setSocieteLike(String societeLike){
        this.societeLike = societeLike;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
    }


}
