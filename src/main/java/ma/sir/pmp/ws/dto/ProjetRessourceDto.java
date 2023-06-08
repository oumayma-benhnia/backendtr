package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjetRessourceDto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal prix  ;
    private String quantite  ;

    private RessourceDto ressource ;
    private ProjetDto projet ;



    public ProjetRessourceDto(){
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
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }


    public RessourceDto getRessource(){
        return this.ressource;
    }

    public void setRessource(RessourceDto ressource){
        this.ressource = ressource;
    }
    public ProjetDto getProjet(){
        return this.projet;
    }

    public void setProjet(ProjetDto projet){
        this.projet = projet;
    }




}
