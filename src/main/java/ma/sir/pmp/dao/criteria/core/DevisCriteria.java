package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DevisCriteria extends BaseCriteria {
    private String reference;
    private String referencelike;

    private String libelle;
    private String libellelike;

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;


    private BigDecimal prixUniHT ;
    private BigDecimal prixUniHTMin ;
    private BigDecimal prixUniHTMax ;
    private LocalDateTime dateEmission ;
    private LocalDateTime dateEmissionFrom ;
    private LocalDateTime dateEmissionTo ;
    private LocalDateTime dateEcheance ;
    private LocalDateTime dateEcheanceFrom ;
    private LocalDateTime dateEcheanceTo ;

    private ClientCriteria client ;

 private List<ClientCriteria> clients;


    private ProjetCriteria projet ;
    private List<ProjetCriteria> projets ;



    public DevisCriteria(){
    }

    public List<ClientCriteria> getClients() {
        return clients;
    }

    public void setClients(List<ClientCriteria> clients) {
        this.clients = clients;
    }

    public List<ProjetCriteria> getProjets() {
        return projets;
    }

    public void setProjets(List<ProjetCriteria> projets) {
        this.projets = projets;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferencelike() {
        return referencelike;
    }

    public void setReferencelike(String referencelike) {
        this.referencelike = referencelike;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibellelike() {
        return libellelike;
    }

    public void setLibellelike(String libellelike) {
        this.libellelike = libellelike;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getQuantiteMin() {
        return quantiteMin;
    }

    public void setQuantiteMin(String quantiteMin) {
        this.quantiteMin = quantiteMin;
    }

    public String getQuantiteMax() {
        return quantiteMax;
    }

    public void setQuantiteMax(String quantiteMax) {
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

    public ProjetCriteria getProjet() {
        return projet;
    }

    public void setProjet(ProjetCriteria projet) {
        this.projet = projet;
    }
}
