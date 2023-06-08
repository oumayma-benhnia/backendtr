package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeclarationDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;

    private TypeDeclarationDto typeDeclaration ;



    public DeclarationDto(){
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


    public TypeDeclarationDto getTypeDeclaration(){
        return this.typeDeclaration;
    }

    public void setTypeDeclaration(TypeDeclarationDto typeDeclaration){
        this.typeDeclaration = typeDeclaration;
    }




}
