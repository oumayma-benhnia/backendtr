package ma.sir.pmp.zynerator.bean;

import java.util.Objects;





import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etablissement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etablissement_seq",sequenceName="etablissement_seq",allocationSize=1, initialValue = 1)
public class Etablissement   extends AuditBusinessObject  {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public Etablissement(){
    super();
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etablissement_seq")
    public Long getId(){
    return this.id;
    }
    public void setId(Long id){
    this.id = id;
    }
    public String getLibelle(){
    return this.libelle;
    }
    public void setLibelle(String libelle){
    this.libelle = libelle;
    }
    public String getCode(){
    return this.code;
    }
    public void setCode(String code){
    this.code = code;
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
    Etablissement etablissement = (Etablissement) o;
    return id != null && id.equals(etablissement.id);
    }

    @Override
    public int hashCode() {
    return Objects.hash(id);
    }

}

