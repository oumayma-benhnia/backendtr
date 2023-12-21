package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import javax.persistence.Column;

public class StagaireCriteria extends BaseCriteria {
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

    private String fonction;
 private String fonctionLike;


    public StagaireCriteria(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeLike() {
        return codeLike;
    }

    public void setCodeLike(String codeLike) {
        this.codeLike = codeLike;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomLike() {
        return nomLike;
    }

    public void setNomLike(String nomLike) {
        this.nomLike = nomLike;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenomLike() {
        return prenomLike;
    }

    public void setPrenomLike(String prenomLike) {
        this.prenomLike = prenomLike;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailLike() {
        return emailLike;
    }

    public void setEmailLike(String emailLike) {
        this.emailLike = emailLike;
    }

    public String getTele() {
        return tele;
    }


    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTeleLike() {
        return teleLike;
    }

    public void setTeleLike(String teleLike) {
        this.teleLike = teleLike;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getFonctionLike() {
        return fonctionLike;
    }

    public void setFonctionLike(String fonctionLike) {
        this.fonctionLike = fonctionLike;
    }
}
