package ma.sir.pmp.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_seq",sequenceName="declaration_seq",allocationSize=1, initialValue = 1)
public class Declaration   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;

    private TypeDeclaration typeDeclaration ;
    


    public Declaration(){
        super();
    }

    public Declaration(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeDeclaration getTypeDeclaration(){
        return this.typeDeclaration;
    }
    public void setTypeDeclaration(TypeDeclaration typeDeclaration){
        this.typeDeclaration = typeDeclaration;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaration declaration = (Declaration) o;
        return id != null && id.equals(declaration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

