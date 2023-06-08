package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;

public class MaterielCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String reference;
    private String referenceLike;
    private String quantite;
    private String quantiteLike;
    private String prix;
    private String prixMin;
    private String prixMax;

    private CategorieMaterielCriteria categorieMateriel ;
    private List<CategorieMaterielCriteria> categorieMateriels ;


    public MaterielCriteria(){}

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

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
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
      

    public CategorieMaterielCriteria getCategorieMateriel(){
        return this.categorieMateriel;
    }

    public void setCategorieMateriel(CategorieMaterielCriteria categorieMateriel){
        this.categorieMateriel = categorieMateriel;
    }
    public List<CategorieMaterielCriteria> getCategorieMateriels(){
        return this.categorieMateriels;
    }

    public void setCategorieMateriels(List<CategorieMaterielCriteria> categorieMateriels){
        this.categorieMateriels = categorieMateriels;
    }
}
