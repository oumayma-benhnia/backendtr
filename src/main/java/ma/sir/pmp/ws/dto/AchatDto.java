package ma.sir.pmp.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AchatDto extends AuditBaseDto {
    private String code;
    private String dateAchat;
    private List<MaterielDto> materiels;
    private FournisseurDto fournisseur;
    public AchatDto(){
        super();
    }
@Log
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

    public List<MaterielDto> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<MaterielDto> materiels) {
        this.materiels = materiels;
    }

    public FournisseurDto getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur) {
        this.fournisseur = fournisseur;
    }
}
