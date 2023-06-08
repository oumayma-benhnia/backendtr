package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;

public class RessourceCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String nom;
    private String nomLike;
    private String prix;
    private String prixMin;
    private String prixMax;
    private String cout;
    private String coutMin;
    private String coutMax;
    private String type;
    private String typeLike;
    private String unite;
    private String uniteLike;

    private FournisseurCriteria fournisseur ;
    private List<FournisseurCriteria> fournisseurs ;
    private MaterielCriteria materiel ;
    private List<MaterielCriteria> materiels ;
    private CollaborateurCriteria collaborateur ;
    private List<CollaborateurCriteria> collaborateurs ;
    private EntiteAdministrativeCriteria entiteAdministrative ;
    private List<EntiteAdministrativeCriteria> entiteAdministratives ;


    public RessourceCriteria(){}

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
      
    public String getCout(){
        return this.cout;
    }
    public void setCout(String cout){
        this.cout = cout;
    }   
    public String getCoutMin(){
        return this.coutMin;
    }
    public void setCoutMin(String coutMin){
        this.coutMin = coutMin;
    }
    public String getCoutMax(){
        return this.coutMax;
    }
    public void setCoutMax(String coutMax){
        this.coutMax = coutMax;
    }
      
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getTypeLike(){
        return this.typeLike;
    }
    public void setTypeLike(String typeLike){
        this.typeLike = typeLike;
    }

    public String getUnite(){
        return this.unite;
    }
    public void setUnite(String unite){
        this.unite = unite;
    }
    public String getUniteLike(){
        return this.uniteLike;
    }
    public void setUniteLike(String uniteLike){
        this.uniteLike = uniteLike;
    }


    public FournisseurCriteria getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurCriteria fournisseur){
        this.fournisseur = fournisseur;
    }
    public List<FournisseurCriteria> getFournisseurs(){
        return this.fournisseurs;
    }

    public void setFournisseurs(List<FournisseurCriteria> fournisseurs){
        this.fournisseurs = fournisseurs;
    }
    public MaterielCriteria getMateriel(){
        return this.materiel;
    }

    public void setMateriel(MaterielCriteria materiel){
        this.materiel = materiel;
    }
    public List<MaterielCriteria> getMateriels(){
        return this.materiels;
    }

    public void setMateriels(List<MaterielCriteria> materiels){
        this.materiels = materiels;
    }
    public CollaborateurCriteria getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurCriteria collaborateur){
        this.collaborateur = collaborateur;
    }
    public List<CollaborateurCriteria> getCollaborateurs(){
        return this.collaborateurs;
    }

    public void setCollaborateurs(List<CollaborateurCriteria> collaborateurs){
        this.collaborateurs = collaborateurs;
    }
    public EntiteAdministrativeCriteria getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeCriteria entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
    public List<EntiteAdministrativeCriteria> getEntiteAdministratives(){
        return this.entiteAdministratives;
    }

    public void setEntiteAdministratives(List<EntiteAdministrativeCriteria> entiteAdministratives){
        this.entiteAdministratives = entiteAdministratives;
    }
}
