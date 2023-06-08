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
public class PaiementDto  extends AuditBaseDto {

    private String code  ;
    private String datePaiement ;
    private BigDecimal montant  ;

    private FactureDto facture ;
    private MoyenPaiementDto moyenPaiement ;



    public PaiementDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public FactureDto getFacture(){
        return this.facture;
    }

    public void setFacture(FactureDto facture){
        this.facture = facture;
    }
    public MoyenPaiementDto getMoyenPaiement(){
        return this.moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiementDto moyenPaiement){
        this.moyenPaiement = moyenPaiement;
    }




}
