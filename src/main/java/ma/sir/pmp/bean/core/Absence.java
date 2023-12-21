package ma.sir.pmp.bean.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "absence")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="absence_seq",sequenceName="absence_seq",allocationSize=1, initialValue = 1)
public class Absence extends AuditBusinessObject {
    private Long id ;
    @Column(length = 500)
    private String code;
    private List<Employe> employes;
    private List<ChefProjet> chefProjets;
    private List<Stagaire> stagaires;
    private LocalDateTime dateAbsence;
    @Column(length = 500)
    private String justification;
    public Absence(){
        super();
    }
    public Absence(Long id,String code) {
        this.id = id;
        this.code = code;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="absence_seq")

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany
    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    @OneToMany
    public List<ChefProjet> getChefProjets() {
        return chefProjets;
    }

    public void setChefProjets(List<ChefProjet> chefProjets) {
        this.chefProjets = chefProjets;
    }
    @OneToMany
    public List<Stagaire> getStagaires() {
        return stagaires;
    }

    public void setStagaires(List<Stagaire> stagaires) {
        this.stagaires = stagaires;
    }

    public LocalDateTime getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(LocalDateTime dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Absence absence = (Absence) o;
        return id != null && id.equals(absence.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

