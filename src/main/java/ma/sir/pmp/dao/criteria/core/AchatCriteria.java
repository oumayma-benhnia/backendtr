package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import java.time.LocalDateTime;
import java.util.List;

public class AchatCriteria extends BaseCriteria {
    private String code;
    private String codeLike;
    private LocalDateTime dateAchat;
    private LocalDateTime dateAchatFrom;
    private LocalDateTime dateAchatTo;
    private List<MaterielCriteria> materiels;
    private MaterielCriteria  materiel;

    private FournisseurCriteria fournisseur;
    private List<FournisseurCriteria> fournisseurs;
    public AchatCriteria(){}

    public List<FournisseurCriteria> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<FournisseurCriteria> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public LocalDateTime getDateAchatFrom() {
        return dateAchatFrom;
    }

    public void setDateAchatFrom(LocalDateTime dateAchatFrom) {
        this.dateAchatFrom = dateAchatFrom;
    }

    public LocalDateTime getDateAchatTo() {
        return dateAchatTo;
    }

    public void setDateAchatTo(LocalDateTime dateAchatTo) {
        this.dateAchatTo = dateAchatTo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeLike() {
        return codeLike;
    }

    public void setCodeLike(String codeLike) {
        this.codeLike = codeLike;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public List<MaterielCriteria> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<MaterielCriteria> materiels) {
        this.materiels = materiels;
    }

    public FournisseurCriteria getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurCriteria fournisseur) {
        this.fournisseur = fournisseur;
    }

    public MaterielCriteria getMateriel() {
        return materiel;
    }

    public void setMateriel(MaterielCriteria materiel) {
        this.materiel = materiel;
    }
}
