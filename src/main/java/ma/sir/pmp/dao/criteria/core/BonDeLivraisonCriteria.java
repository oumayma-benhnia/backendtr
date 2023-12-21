package ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BonDeLivraisonCriteria extends BaseCriteria {
    private String reference;
    private String referenceLike;

    private String libelle;
    private String libelleLike;

    private String description;
    private String descriptionLike;

    private Double quantite;
    private Double quantiteMin;
    private Double quantiteMax;
    private BigDecimal prixUniHT ;
    private BigDecimal prixUniHTMin ;
    private BigDecimal prixUniHTMax ;
    private LocalDateTime dateLivraison ;
    private LocalDateTime dateLivraisonFrom ;
    private LocalDateTime dateLivraisonTo ;
    private String lieuLivraison;
    private String lieuLivraisonLike;


    private ClientCriteria client ;
     private List<ClientCriteria> clients ;

    private FournisseurCriteria fournisseur;

   private List<FournisseurCriteria> fournisseurs;


    public BonDeLivraisonCriteria(){}

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceLike() {
        return referenceLike;
    }

    public void setReferenceLike(String referenceLike) {
        this.referenceLike = referenceLike;
    }

    public List<ClientCriteria> getClients() {
        return clients;
    }

    public void setClients(List<ClientCriteria> clients) {
        this.clients = clients;
    }

    public List<FournisseurCriteria> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<FournisseurCriteria> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleLike() {
        return libelleLike;
    }

    public void setLibelleLike(String libelleLike) {
        this.libelleLike = libelleLike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionLike() {
        return descriptionLike;
    }

    public void setDescriptionLike(String descriptionLike) {
        this.descriptionLike = descriptionLike;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getQuantiteMin() {
        return quantiteMin;
    }

    public void setQuantiteMin(Double quantiteMin) {
        this.quantiteMin = quantiteMin;
    }

    public Double getQuantiteMax() {
        return quantiteMax;
    }

    public void setQuantiteMax(Double quantiteMax) {
        this.quantiteMax = quantiteMax;
    }

    public BigDecimal getPrixUniHT() {
        return prixUniHT;
    }

    public void setPrixUniHT(BigDecimal prixUniHT) {
        this.prixUniHT = prixUniHT;
    }

    public BigDecimal getPrixUniHTMin() {
        return prixUniHTMin;
    }

    public void setPrixUniHTMin(BigDecimal prixUniHTMin) {
        this.prixUniHTMin = prixUniHTMin;
    }

    public BigDecimal getPrixUniHTMax() {
        return prixUniHTMax;
    }

    public void setPrixUniHTMax(BigDecimal prixUniHTMax) {
        this.prixUniHTMax = prixUniHTMax;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public LocalDateTime getDateLivraisonFrom() {
        return dateLivraisonFrom;
    }

    public void setDateLivraisonFrom(LocalDateTime dateLivraisonFrom) {
        this.dateLivraisonFrom = dateLivraisonFrom;
    }

    public LocalDateTime getDateLivraisonTo() {
        return dateLivraisonTo;
    }

    public void setDateLivraisonTo(LocalDateTime dateLivraisonTo) {
        this.dateLivraisonTo = dateLivraisonTo;
    }

    public String getLieuLivraison() {
        return lieuLivraison;
    }

    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
    }

    public String getLieuLivraisonLike() {
        return lieuLivraisonLike;
    }

    public void setLieuLivraisonLike(String lieuLivraisonLike) {
        this.lieuLivraisonLike = lieuLivraisonLike;
    }

    public ClientCriteria getClient() {
        return client;
    }

    public void setClient(ClientCriteria client) {
        this.client = client;
    }

    public FournisseurCriteria getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurCriteria fournisseur) {
        this.fournisseur = fournisseur;
    }
}
