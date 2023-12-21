package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import javax.persistence.Column;

public class TypeVenteCriteria extends BaseCriteria {

    private String code;
    private String codeLike;

    private String libelle;

 private String libelleLike;



    public TypeVenteCriteria(){}

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleLike() {
        return libelleLike;
    }

    public void setLibelleLike(String libelleLike) {
        this.libelleLike = libelleLike;
    }
}
