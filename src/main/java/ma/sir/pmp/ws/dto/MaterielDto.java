package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaterielDto  extends AuditBaseDto {

    private String libelle  ;
    private String reference  ;
    private String quantite  ;
    private BigDecimal prix  ;

    private CategorieMaterielDto categorieMateriel ;



    public MaterielDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }


    public CategorieMaterielDto getCategorieMateriel(){
        return this.categorieMateriel;
    }

    public void setCategorieMateriel(CategorieMaterielDto categorieMateriel){
        this.categorieMateriel = categorieMateriel;
    }




}
