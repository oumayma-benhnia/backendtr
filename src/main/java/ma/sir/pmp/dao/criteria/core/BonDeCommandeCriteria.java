package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BonDeCommandeCriteria extends BaseCriteria {
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
    private LocalDateTime dateEmission ;
    private LocalDateTime dateEmissionFrom ;
    private LocalDateTime dateEmissionTo;
    private LocalDateTime dateEcheance ;
    private LocalDateTime dateEcheanceFrom ;
    private LocalDateTime dateEcheanceTo ;

    private ClientCriteria client ;

    private List<ClientCriteria> clients ;


    public BonDeCommandeCriteria(){}

    public List<ClientCriteria> getClients() {
        return clients;
    }

    public void setClients(List<ClientCriteria> clients) {
        this.clients = clients;
    }

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

    public LocalDateTime getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDateTime dateEmission) {
        this.dateEmission = dateEmission;
    }

    public LocalDateTime getDateEmissionFrom() {
        return dateEmissionFrom;
    }

    public void setDateEmissionFrom(LocalDateTime dateEmissionFrom) {
        this.dateEmissionFrom = dateEmissionFrom;
    }

    public LocalDateTime getDateEmissionTo() {
        return dateEmissionTo;
    }

    public void setDateEmissionTo(LocalDateTime dateEmissionTo) {
        this.dateEmissionTo = dateEmissionTo;
    }

    public LocalDateTime getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDateTime dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public LocalDateTime getDateEcheanceFrom() {
        return dateEcheanceFrom;
    }

    public void setDateEcheanceFrom(LocalDateTime dateEcheanceFrom) {
        this.dateEcheanceFrom = dateEcheanceFrom;
    }

    public LocalDateTime getDateEcheanceTo() {
        return dateEcheanceTo;
    }

    public void setDateEcheanceTo(LocalDateTime dateEcheanceTo) {
        this.dateEcheanceTo = dateEcheanceTo;
    }

    public ClientCriteria getClient() {
        return client;
    }

    public void setClient(ClientCriteria client) {
        this.client = client;
    }
}
