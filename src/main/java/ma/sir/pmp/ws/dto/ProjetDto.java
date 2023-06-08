package  ma.sir.pmp.ws.dto;

import ma.sir.pmp.zynerator.audit.Log;
import ma.sir.pmp.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjetDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;
    private BigDecimal budget  ;
    private String progression  ;
    private String dateDebut ;
    private String dateFinEstime ;
    private String dateFin ;

    private TypeProjetDto typeProjet ;
    private ClientDto client ;
    private ChefProjetDto chefProjet ;

    private List<ProjetRessourceDto> projetRessources ;
    private List<TacheDto> taches ;
    private List<RemarqueDto> remarques ;


    public ProjetDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public BigDecimal getBudget(){
        return this.budget;
    }
    public void setBudget(BigDecimal budget){
        this.budget = budget;
    }

    @Log
    public String getProgression(){
        return this.progression;
    }
    public void setProgression(String progression){
        this.progression = progression;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFinEstime(){
        return this.dateFinEstime;
    }
    public void setDateFinEstime(String dateFinEstime){
        this.dateFinEstime = dateFinEstime;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }


    public TypeProjetDto getTypeProjet(){
        return this.typeProjet;
    }

    public void setTypeProjet(TypeProjetDto typeProjet){
        this.typeProjet = typeProjet;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public ChefProjetDto getChefProjet(){
        return this.chefProjet;
    }

    public void setChefProjet(ChefProjetDto chefProjet){
        this.chefProjet = chefProjet;
    }



    public List<ProjetRessourceDto> getProjetRessources(){
        return this.projetRessources;
    }

    public void setProjetRessources(List<ProjetRessourceDto> projetRessources){
        this.projetRessources = projetRessources;
    }
    public List<TacheDto> getTaches(){
        return this.taches;
    }

    public void setTaches(List<TacheDto> taches){
        this.taches = taches;
    }
    public List<RemarqueDto> getRemarques(){
        return this.remarques;
    }

    public void setRemarques(List<RemarqueDto> remarques){
        this.remarques = remarques;
    }

}
