package ma.sir.pmp.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "remarque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="remarque_seq",sequenceName="remarque_seq",allocationSize=1, initialValue = 1)
public class Remarque   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private LocalDateTime dateRemarque ;

    private Projet projet ;
    


    public Remarque(){
        super();
    }

    public Remarque(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="remarque_seq")
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
    public LocalDateTime getDateRemarque(){
        return this.dateRemarque;
    }
    public void setDateRemarque(LocalDateTime dateRemarque){
        this.dateRemarque = dateRemarque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Projet getProjet(){
        return this.projet;
    }
    public void setProjet(Projet projet){
        this.projet = projet;
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
        Remarque remarque = (Remarque) o;
        return id != null && id.equals(remarque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

