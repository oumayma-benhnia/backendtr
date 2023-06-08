package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private FactureCriteria facture ;
    private List<FactureCriteria> factures ;
    private MoyenPaiementCriteria moyenPaiement ;
    private List<MoyenPaiementCriteria> moyenPaiements ;


    public PaiementCriteria(){}

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

    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
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
      

    public FactureCriteria getFacture(){
        return this.facture;
    }

    public void setFacture(FactureCriteria facture){
        this.facture = facture;
    }
    public List<FactureCriteria> getFactures(){
        return this.factures;
    }

    public void setFactures(List<FactureCriteria> factures){
        this.factures = factures;
    }
    public MoyenPaiementCriteria getMoyenPaiement(){
        return this.moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiementCriteria moyenPaiement){
        this.moyenPaiement = moyenPaiement;
    }
    public List<MoyenPaiementCriteria> getMoyenPaiements(){
        return this.moyenPaiements;
    }

    public void setMoyenPaiements(List<MoyenPaiementCriteria> moyenPaiements){
        this.moyenPaiements = moyenPaiements;
    }
}
