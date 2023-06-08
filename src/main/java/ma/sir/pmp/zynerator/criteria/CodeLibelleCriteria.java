package ma.sir.pmp.zynerator.criteria;

import java.util.List;

public class CodeLibelleCriteria extends CodeCriteria {

    /**
     * Fields.
     */


    protected String libelle;
    protected String libelleLike;
    protected String actif;
    protected List<Long> actifAndIds;
    protected String hl7;
    protected String hl7Like;
    protected String ordre;


    /**
     * Methods.
     */

    public String getLibelleLike() {
        return this.libelleLike;
    }

    public void setLibelleLike(String libelleLike) {
        this.libelleLike = libelleLike;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return this.actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public List<Long> getActifAndIds() {
        return actifAndIds;
    }

    public void setActifAndIds(List<Long> actifAndIds) {
        this.actifAndIds = actifAndIds;
    }

    public String getHl7Like() {
        return this.hl7Like;
    }

    public void setHl7Like(String hl7Like) {
        this.hl7Like = hl7Like;
    }

    public String getHl7() {
        return this.hl7;
    }

    public void setHl7(String hl7) {
        this.hl7 = hl7;
    }

    public String getOrdre() {
        return this.ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }


}
