package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.core.Stagaire;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbsenceDto extends AuditBaseDto {

    private String code;
    private List<EmployeDto> employes;
    private List<ChefProjetDto> chefProjets;
    private List<StagaireDto> stagaires;
    private String dateAbsence;

    private String justification;
    public AbsenceDto(){
        super();
    }
@Log
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EmployeDto> getEmployes() {
        return employes;
    }

    public void setEmployes(List<EmployeDto> employes) {
        this.employes = employes;
    }

    public List<ChefProjetDto> getChefProjets() {
        return chefProjets;
    }

    public void setChefProjets(List<ChefProjetDto> chefProjets) {
        this.chefProjets = chefProjets;
    }

    public List<StagaireDto> getStagaires() {
        return stagaires;
    }

    public void setStagaires(List<StagaireDto> stagaires) {
        this.stagaires = stagaires;
    }
    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(String dateAbsence) {
        this.dateAbsence = dateAbsence;
    }
@Log
    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
}
