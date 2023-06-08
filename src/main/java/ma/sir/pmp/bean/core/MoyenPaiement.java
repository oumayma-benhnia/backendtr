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
@Table(name = "moyen_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="moyen_paiement_seq",sequenceName="moyen_paiement_seq",allocationSize=1, initialValue = 1)
public class MoyenPaiement   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    private LocalDateTime dateRemarque ;



    public MoyenPaiement(){
        super();
    }

    public MoyenPaiement(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="moyen_paiement_seq")
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

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoyenPaiement moyenPaiement = (MoyenPaiement) o;
        return id != null && id.equals(moyenPaiement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

