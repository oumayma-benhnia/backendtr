package ma.sir.pmp.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_seq",sequenceName="paiement_seq",allocationSize=1, initialValue = 1)
public class Paiement   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private LocalDateTime datePaiement ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Facture facture ;
    
    private MoyenPaiement moyenPaiement ;
    


    public Paiement(){
        super();
    }

    public Paiement(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Facture getFacture(){
        return this.facture;
    }
    public void setFacture(Facture facture){
        this.facture = facture;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public MoyenPaiement getMoyenPaiement(){
        return this.moyenPaiement;
    }
    public void setMoyenPaiement(MoyenPaiement moyenPaiement){
        this.moyenPaiement = moyenPaiement;
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
        Paiement paiement = (Paiement) o;
        return id != null && id.equals(paiement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

