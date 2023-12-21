package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.core.Stagaire;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class AbsenceCriteria  extends BaseCriteria {
    private String code;
    private String codeLike;

    private List<EmployeCriteria> employes;
    private EmployeCriteria employe;
    private List<ChefProjetCriteria> chefProjets;
    private ChefProjetCriteria chefProjet;
    private List<StagaireCriteria> stagaires;
    private StagaireCriteria stagaire;
    private LocalDateTime dateAbsence;
    private LocalDateTime dateAbsenceFrom;
    private LocalDateTime dateAbsenceTo;

    private String justification;
    private String justificationLike;
    public AbsenceCriteria(){}

    public EmployeCriteria getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeCriteria employe) {
        this.employe = employe;
    }

    public ChefProjetCriteria getChefProjet() {
        return chefProjet;
    }

    public void setChefProjet(ChefProjetCriteria chefProjet) {
        this.chefProjet = chefProjet;
    }

    public StagaireCriteria getStagaire() {
        return stagaire;
    }

    public void setStagaire(StagaireCriteria stagaire) {
        this.stagaire = stagaire;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getDateAbsenceFrom() {
        return dateAbsenceFrom;
    }

    public void setDateAbsenceFrom(LocalDateTime dateAbsenceFrom) {
        this.dateAbsenceFrom = dateAbsenceFrom;
    }

    public LocalDateTime getDateAbsenceTo() {
        return dateAbsenceTo;
    }

    public void setDateAbsenceTo(LocalDateTime dateAbsenceTo) {
        this.dateAbsenceTo = dateAbsenceTo;
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

    public List<EmployeCriteria> getEmployes() {
        return employes;
    }

    public void setEmployes(List<EmployeCriteria> employes) {
        this.employes = employes;
    }

    public List<ChefProjetCriteria> getChefProjets() {
        return chefProjets;
    }

    public void setChefProjets(List<ChefProjetCriteria> chefProjets) {
        this.chefProjets = chefProjets;
    }

    public List<StagaireCriteria> getStagaires() {
        return stagaires;
    }

    public void setStagaires(List<StagaireCriteria> stagaires) {
        this.stagaires = stagaires;
    }

    public LocalDateTime getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(LocalDateTime dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getJustificationLike() {
        return justificationLike;
    }

    public void setJustificationLike(String justificationLike) {
        this.justificationLike = justificationLike;
    }
}
