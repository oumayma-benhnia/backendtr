package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProjetRessourceCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String prix;
    private String prixMin;
    private String prixMax;
    private String quantite;
    private String quantiteLike;

    private RessourceCriteria ressource ;
    private List<RessourceCriteria> ressources ;
    private ProjetCriteria projet ;
    private List<ProjetCriteria> projets ;


    public ProjetRessourceCriteria(){}

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

    public String getPrix(){
        return this.prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }   
    public String getPrixMin(){
        return this.prixMin;
    }
    public void setPrixMin(String prixMin){
        this.prixMin = prixMin;
    }
    public String getPrixMax(){
        return this.prixMax;
    }
    public void setPrixMax(String prixMax){
        this.prixMax = prixMax;
    }
      
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }
    public String getQuantiteLike(){
        return this.quantiteLike;
    }
    public void setQuantiteLike(String quantiteLike){
        this.quantiteLike = quantiteLike;
    }


    public RessourceCriteria getRessource(){
        return this.ressource;
    }

    public void setRessource(RessourceCriteria ressource){
        this.ressource = ressource;
    }
    public List<RessourceCriteria> getRessources(){
        return this.ressources;
    }

    public void setRessources(List<RessourceCriteria> ressources){
        this.ressources = ressources;
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
