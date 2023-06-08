package  ma.sir.pmp.dao.criteria.core;


import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ProjetCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String libelle;
    private String libelleLike;
    private String budget;
    private String budgetMin;
    private String budgetMax;
    private String progression;
    private String progressionLike;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFinEstime;
    private LocalDateTime dateFinEstimeFrom;
    private LocalDateTime dateFinEstimeTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;

    private TypeProjetCriteria typeProjet ;
    private List<TypeProjetCriteria> typeProjets ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private ChefProjetCriteria chefProjet ;
    private List<ChefProjetCriteria> chefProjets ;


    public ProjetCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getBudget(){
        return this.budget;
    }
    public void setBudget(String budget){
        this.budget = budget;
    }   
    public String getBudgetMin(){
        return this.budgetMin;
    }
    public void setBudgetMin(String budgetMin){
        this.budgetMin = budgetMin;
    }
    public String getBudgetMax(){
        return this.budgetMax;
    }
    public void setBudgetMax(String budgetMax){
        this.budgetMax = budgetMax;
    }
      
    public String getProgression(){
        return this.progression;
    }
    public void setProgression(String progression){
        this.progression = progression;
    }
    public String getProgressionLike(){
        return this.progressionLike;
    }
    public void setProgressionLike(String progressionLike){
        this.progressionLike = progressionLike;
    }

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFinEstime(){
        return this.dateFinEstime;
    }
    public void setDateFinEstime(LocalDateTime dateFinEstime){
        this.dateFinEstime = dateFinEstime;
    }
    public LocalDateTime getDateFinEstimeFrom(){
        return this.dateFinEstimeFrom;
    }
    public void setDateFinEstimeFrom(LocalDateTime dateFinEstimeFrom){
        this.dateFinEstimeFrom = dateFinEstimeFrom;
    }
    public LocalDateTime getDateFinEstimeTo(){
        return this.dateFinEstimeTo;
    }
    public void setDateFinEstimeTo(LocalDateTime dateFinEstimeTo){
        this.dateFinEstimeTo = dateFinEstimeTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }

    public TypeProjetCriteria getTypeProjet(){
        return this.typeProjet;
    }

    public void setTypeProjet(TypeProjetCriteria typeProjet){
        this.typeProjet = typeProjet;
    }
    public List<TypeProjetCriteria> getTypeProjets(){
        return this.typeProjets;
    }

    public void setTypeProjets(List<TypeProjetCriteria> typeProjets){
        this.typeProjets = typeProjets;
    }
    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public ChefProjetCriteria getChefProjet(){
        return this.chefProjet;
    }

    public void setChefProjet(ChefProjetCriteria chefProjet){
        this.chefProjet = chefProjet;
    }
    public List<ChefProjetCriteria> getChefProjets(){
        return this.chefProjets;
    }

    public void setChefProjets(List<ChefProjetCriteria> chefProjets){
        this.chefProjets = chefProjets;
    }
}
