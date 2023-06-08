package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FactureCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String libelle;
    private String libelleLike;
    private String montant;
    private String montantMin;
    private String montantMax;
    private LocalDateTime dateEmission;
    private LocalDateTime dateEmissionFrom;
    private LocalDateTime dateEmissionTo;
    private LocalDateTime dateEcheance;
    private LocalDateTime dateEcheanceFrom;
    private LocalDateTime dateEcheanceTo;

    private ComptableCriteria comptable ;
    private List<ComptableCriteria> comptables ;
    private ProjetCriteria projet ;
    private List<ProjetCriteria> projets ;


    public FactureCriteria(){}

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

    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public LocalDateTime getDateEmissionFrom(){
        return this.dateEmissionFrom;
    }
    public void setDateEmissionFrom(LocalDateTime dateEmissionFrom){
        this.dateEmissionFrom = dateEmissionFrom;
    }
    public LocalDateTime getDateEmissionTo(){
        return this.dateEmissionTo;
    }
    public void setDateEmissionTo(LocalDateTime dateEmissionTo){
        this.dateEmissionTo = dateEmissionTo;
    }
    public LocalDateTime getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(LocalDateTime dateEcheance){
        this.dateEcheance = dateEcheance;
    }
    public LocalDateTime getDateEcheanceFrom(){
        return this.dateEcheanceFrom;
    }
    public void setDateEcheanceFrom(LocalDateTime dateEcheanceFrom){
        this.dateEcheanceFrom = dateEcheanceFrom;
    }
    public LocalDateTime getDateEcheanceTo(){
        return this.dateEcheanceTo;
    }
    public void setDateEcheanceTo(LocalDateTime dateEcheanceTo){
        this.dateEcheanceTo = dateEcheanceTo;
    }

    public ComptableCriteria getComptable(){
        return this.comptable;
    }

    public void setComptable(ComptableCriteria comptable){
        this.comptable = comptable;
    }
    public List<ComptableCriteria> getComptables(){
        return this.comptables;
    }

    public void setComptables(List<ComptableCriteria> comptables){
        this.comptables = comptables;
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
