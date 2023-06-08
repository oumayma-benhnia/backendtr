package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DeclarationCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String libelle;
    private String libelleLike;

    private TypeDeclarationCriteria typeDeclaration ;
    private List<TypeDeclarationCriteria> typeDeclarations ;


    public DeclarationCriteria(){}

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


    public TypeDeclarationCriteria getTypeDeclaration(){
        return this.typeDeclaration;
    }

    public void setTypeDeclaration(TypeDeclarationCriteria typeDeclaration){
        this.typeDeclaration = typeDeclaration;
    }
    public List<TypeDeclarationCriteria> getTypeDeclarations(){
        return this.typeDeclarations;
    }

    public void setTypeDeclarations(List<TypeDeclarationCriteria> typeDeclarations){
        this.typeDeclarations = typeDeclarations;
    }
}
