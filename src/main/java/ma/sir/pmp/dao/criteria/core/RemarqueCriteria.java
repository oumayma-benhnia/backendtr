package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class RemarqueCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private LocalDateTime dateRemarque;
    private LocalDateTime dateRemarqueFrom;
    private LocalDateTime dateRemarqueTo;

    private ProjetCriteria projet ;
    private List<ProjetCriteria> projets ;


    public RemarqueCriteria(){}

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

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public LocalDateTime getDateRemarque(){
        return this.dateRemarque;
    }
    public void setDateRemarque(LocalDateTime dateRemarque){
        this.dateRemarque = dateRemarque;
    }
    public LocalDateTime getDateRemarqueFrom(){
        return this.dateRemarqueFrom;
    }
    public void setDateRemarqueFrom(LocalDateTime dateRemarqueFrom){
        this.dateRemarqueFrom = dateRemarqueFrom;
    }
    public LocalDateTime getDateRemarqueTo(){
        return this.dateRemarqueTo;
    }
    public void setDateRemarqueTo(LocalDateTime dateRemarqueTo){
        this.dateRemarqueTo = dateRemarqueTo;
    }

    public ProjetCriteria getProjet(){
        return this.projet;
    }

    public void setProjet(ProjetCriteria projet){
        this.projet = projet;
    }
    public List<ProjetCriteria> getProjets(){
        return this.projets;
    }

    public void setProjets(List<ProjetCriteria> projets){
        this.projets = projets;
    }
}
