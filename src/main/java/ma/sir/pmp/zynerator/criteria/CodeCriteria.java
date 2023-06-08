package ma.sir.pmp.zynerator.criteria;

public class CodeCriteria extends BaseCriteria {

    /**
     * Fields.
     */

    protected String code;
    protected String codeLike;
    protected Long etablissementId;


    /**
     * Methods.
     */

    public String getCodeLike() {
        return this.codeLike;
    }

    public void setCodeLike(String codeLike) {
        this.codeLike = codeLike;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getEtablissementId() {
        return this.etablissementId;
    }

    public void setEtablissementId(Long etablissementId) {
        this.etablissementId = etablissementId;
    }


}
