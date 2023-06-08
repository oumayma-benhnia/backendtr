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
@Table(name = "facture")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="facture_seq",sequenceName="facture_seq",allocationSize=1, initialValue = 1)
public class Facture   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;
    private BigDecimal montant = BigDecimal.ZERO;
    private LocalDateTime dateEmission ;
    private LocalDateTime dateEcheance ;

    private Comptable comptable ;
    
    private Projet projet ;
    


    public Facture(){
        super();
    }

    public Facture(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_seq")
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public LocalDateTime getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(LocalDateTime dateEcheance){
        this.dateEcheance = dateEcheance;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Comptable getComptable(){
        return this.comptable;
    }
    public void setComptable(Comptable comptable){
        this.comptable = comptable;
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
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return id != null && id.equals(facture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

