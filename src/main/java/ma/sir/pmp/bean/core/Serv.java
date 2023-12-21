package ma.sir.pmp.bean.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "serv")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="serv_seq", sequenceName="serv_seq", allocationSize=1, initialValue = 1)
public class Serv extends AuditBusinessObject {

    private Long id;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;

    public Serv() {
        super();
    }

    public Serv(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serv_seq")
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
        Serv serv = (Serv) o;
        return id != null && id.equals(serv.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
