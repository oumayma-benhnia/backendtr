package ma.sir.pmp.bean.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typeVente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="typeVente_seq",sequenceName="typeVente_seq",allocationSize=1, initialValue = 1)
public class TypeVente extends AuditBusinessObject {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public TypeVente(){
        super();
    }

    public TypeVente(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="typeVente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
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
        TypeVente typeVente = (TypeVente) o;
        return id != null && id.equals(typeVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
