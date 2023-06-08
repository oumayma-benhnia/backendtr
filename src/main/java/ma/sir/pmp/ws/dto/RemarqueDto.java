package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemarqueDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private String dateRemarque ;

    private ProjetDto projet ;



    public RemarqueDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateRemarque(){
        return this.dateRemarque;
    }
    public void setDateRemarque(String dateRemarque){
        this.dateRemarque = dateRemarque;
    }


    public ProjetDto getProjet(){
        return this.projet;
    }

    public void setProjet(ProjetDto projet){
        this.projet = projet;
    }




}
