package ma.sir.pmp.bean.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="service_seq",sequenceName="service_seq",allocationSize=1, initialValue = 1)

public class Service extends AuditBusinessObject {

    private Long id ;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    public Service(){
        super();
    }

    public Service(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="service_seq")

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id != null && id.equals(service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

