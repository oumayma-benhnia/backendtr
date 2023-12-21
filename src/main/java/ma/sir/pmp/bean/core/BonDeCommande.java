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
@Table(name = "bonCommande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bonCommande_seq",sequenceName="bonCommande_seq",allocationSize=1, initialValue = 1)
public class BonDeCommande extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private Double quantite;
    private BigDecimal prixUniHT = BigDecimal.ZERO;
    private LocalDateTime dateEmission ;
    private LocalDateTime dateEcheance ;

    private Client client ;


    public BonDeCommande(){
        super();
    }

    public BonDeCommande(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bonCommande_seq")
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUniHT() {
        return prixUniHT;
    }

    public void setPrixUniHT(BigDecimal prixUniHT) {
        this.prixUniHT = prixUniHT;
    }

    public LocalDateTime getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDateTime dateEmission) {
        this.dateEmission = dateEmission;
    }

    public LocalDateTime getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDateTime dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        BonDeCommande bonDeCommande = (BonDeCommande) o;
        return id != null && id.equals(bonDeCommande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

