package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactureDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;
    private BigDecimal montant  ;
    private String dateEmission ;
    private String dateEcheance ;

    private ComptableDto comptable ;
    private ProjetDto projet ;



    public FactureDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(String dateEmission){
        this.dateEmission = dateEmission;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(String dateEcheance){
        this.dateEcheance = dateEcheance;
    }


    public ComptableDto getComptable(){
        return this.comptable;
    }

    public void setComptable(ComptableDto comptable){
        this.comptable = comptable;
    }
    public ProjetDto getProjet(){
        return this.projet;
    }

    public void setProjet(ProjetDto projet){
        this.projet = projet;
    }




}
