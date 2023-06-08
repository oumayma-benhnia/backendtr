package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RessourceDto  extends AuditBaseDto {

    private String code  ;
    private String nom  ;
    private BigDecimal prix  ;
    private BigDecimal cout  ;
    private String type  ;
    private String unite  ;

    private FournisseurDto fournisseur ;
    private MaterielDto materiel ;
    private CollaborateurDto collaborateur ;
    private EntiteAdministrativeDto entiteAdministrative ;



    public RessourceDto(){
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
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public BigDecimal getCout(){
        return this.cout;
    }
    public void setCout(BigDecimal cout){
        this.cout = cout;
    }

    @Log
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    @Log
    public String getUnite(){
        return this.unite;
    }
    public void setUnite(String unite){
        this.unite = unite;
    }


    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public MaterielDto getMateriel(){
        return this.materiel;
    }

    public void setMateriel(MaterielDto materiel){
        this.materiel = materiel;
    }
    public CollaborateurDto getCollaborateur(){
        return this.collaborateur;
    }

    public void setCollaborateur(CollaborateurDto collaborateur){
        this.collaborateur = collaborateur;
    }
    public EntiteAdministrativeDto getEntiteAdministrative(){
        return this.entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrativeDto entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }




}
