package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BonDeLivraisonDto extends AuditBaseDto {
    private String reference;
    private String libelle;
    private String description;
    private Double quantite;
    private BigDecimal prixUniHT ;
    private String dateLivraison ;
    private String lieuLivraison;


    private ClientDto client ;
    private FournisseurDto fournisseur;


    public BonDeLivraisonDto(){
        super();
    }
@Log
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
@Log
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
@Log
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@Log
    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
@Log
    public BigDecimal getPrixUniHT() {
        return prixUniHT;
    }

    public void setPrixUniHT(BigDecimal prixUniHT) {
        this.prixUniHT = prixUniHT;
    }
    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    @Log
    public String getLieuLivraison() {
        return lieuLivraison;
    }

    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public FournisseurDto getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur) {
        this.fournisseur = fournisseur;
    }
}
