package ma.sir.pmp.zynerator.criteria;

public class BaseCriteriaEnhanced extends BaseCriteria {

     /**
    * Fields.
    */

    protected Boolean actif;
    protected Boolean actifLike;

    protected String ordreLike;
    protected String ordre;



    /**
    * Methods.
    */

    public Boolean isActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean isActifLike() {
        return actifLike;
    }

    public void setActifLike(Boolean actifLike) {
        this.actifLike = actifLike;
    }

    public String getOrdreLike() {
        return ordreLike;
    }

    public void setOrdreLike(String ordreLike) {
        this.ordreLike = ordreLike;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }
}
