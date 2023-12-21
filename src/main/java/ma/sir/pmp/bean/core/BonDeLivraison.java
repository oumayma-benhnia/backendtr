package ma.sir.pmp.bean.core;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "bonLivraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bonLivraison_seq",sequenceName="bonLivraison_seq",allocationSize=1, initialValue = 1)
public class BonDeLivraison extends AuditBusinessObject     {

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
    private LocalDateTime dateLivraison ;
    private String lieuLivraison;


    private Client client ;
    private Fournisseur fournisseur;


    public BonDeLivraison(){
        super();
    }

    public BonDeLivraison(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bonCommande_seq")
    public Long getId() {
        return id;
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

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getLieuLivraison() {
        return lieuLivraison;
    }

    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
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
        BonDeLivraison bonDeLivraison = (BonDeLivraison) o;
        return id != null && id.equals(bonDeLivraison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


