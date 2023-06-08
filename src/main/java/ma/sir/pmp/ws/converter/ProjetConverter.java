package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.pmp.zynerator.util.ListUtil;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.ProjetHistory;
import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.ws.dto.ProjetDto;

@Component
public class ProjetConverter extends AbstractConverter<Projet, ProjetDto, ProjetHistory> {

    @Autowired
    private RemarqueConverter remarqueConverter ;
    @Autowired
    private TypeProjetConverter typeProjetConverter ;
    @Autowired
    private RessourceConverter ressourceConverter ;
    @Autowired
    private ProjetRessourceConverter projetRessourceConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ChefProjetConverter chefProjetConverter ;
    @Autowired
    private TacheConverter tacheConverter ;
    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    private boolean typeProjet;
    private boolean client;
    private boolean chefProjet;
    private boolean projetRessources;
    private boolean taches;
    private boolean remarques;

    public  ProjetConverter(){
        super(Projet.class, ProjetDto.class, ProjetHistory.class);
        init(true);
    }

    @Override
    public Projet toItem(ProjetDto dto) {
        if (dto == null) {
            return null;
        } else {
        Projet item = new Projet();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getBudget()))
                item.setBudget(dto.getBudget());
            if(StringUtil.isNotEmpty(dto.getProgression()))
                item.setProgression(dto.getProgression());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFinEstime()))
                item.setDateFinEstime(DateUtil.stringEnToDate(dto.getDateFinEstime()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(this.typeProjet && dto.getTypeProjet()!=null)
                item.setTypeProjet(typeProjetConverter.toItem(dto.getTypeProjet())) ;

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.chefProjet && dto.getChefProjet()!=null)
                item.setChefProjet(chefProjetConverter.toItem(dto.getChefProjet())) ;


            if(this.projetRessources && ListUtil.isNotEmpty(dto.getProjetRessources()))
                item.setProjetRessources(projetRessourceConverter.toItem(dto.getProjetRessources()));
            if(this.taches && ListUtil.isNotEmpty(dto.getTaches()))
                item.setTaches(tacheConverter.toItem(dto.getTaches()));
            if(this.remarques && ListUtil.isNotEmpty(dto.getRemarques()))
                item.setRemarques(remarqueConverter.toItem(dto.getRemarques()));

        return item;
        }
    }

    @Override
    public ProjetDto toDto(Projet item) {
        if (item == null) {
            return null;
        } else {
            ProjetDto dto = new ProjetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getBudget()))
                dto.setBudget(item.getBudget());
            if(StringUtil.isNotEmpty(item.getProgression()))
                dto.setProgression(item.getProgression());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFinEstime()!=null)
                dto.setDateFinEstime(DateUtil.dateTimeToString(item.getDateFinEstime()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
        if(this.typeProjet && item.getTypeProjet()!=null) {
            dto.setTypeProjet(typeProjetConverter.toDto(item.getTypeProjet())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.chefProjet && item.getChefProjet()!=null) {
            dto.setChefProjet(chefProjetConverter.toDto(item.getChefProjet())) ;
        }
        if(this.projetRessources && ListUtil.isNotEmpty(item.getProjetRessources())){
            projetRessourceConverter.init(true);
            projetRessourceConverter.setProjet(false);
            dto.setProjetRessources(projetRessourceConverter.toDto(item.getProjetRessources()));
            projetRessourceConverter.setProjet(true);

        }
        if(this.taches && ListUtil.isNotEmpty(item.getTaches())){
            tacheConverter.init(true);
            tacheConverter.setProjet(false);
            dto.setTaches(tacheConverter.toDto(item.getTaches()));
            tacheConverter.setProjet(true);

        }
        if(this.remarques && ListUtil.isNotEmpty(item.getRemarques())){
            remarqueConverter.init(true);
            remarqueConverter.setProjet(false);
            dto.setRemarques(remarqueConverter.toDto(item.getRemarques()));
            remarqueConverter.setProjet(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.projetRessources = value;
        this.taches = value;
        this.remarques = value;
    }

    public void initObject(boolean value) {
        this.typeProjet = value;
        this.client = value;
        this.chefProjet = value;
    }


    public RemarqueConverter getRemarqueConverter(){
        return this.remarqueConverter;
    }
    public void setRemarqueConverter(RemarqueConverter remarqueConverter ){
        this.remarqueConverter = remarqueConverter;
    }
    public TypeProjetConverter getTypeProjetConverter(){
        return this.typeProjetConverter;
    }
    public void setTypeProjetConverter(TypeProjetConverter typeProjetConverter ){
        this.typeProjetConverter = typeProjetConverter;
    }
    public RessourceConverter getRessourceConverter(){
        return this.ressourceConverter;
    }
    public void setRessourceConverter(RessourceConverter ressourceConverter ){
        this.ressourceConverter = ressourceConverter;
    }
    public ProjetRessourceConverter getProjetRessourceConverter(){
        return this.projetRessourceConverter;
    }
    public void setProjetRessourceConverter(ProjetRessourceConverter projetRessourceConverter ){
        this.projetRessourceConverter = projetRessourceConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public ChefProjetConverter getChefProjetConverter(){
        return this.chefProjetConverter;
    }
    public void setChefProjetConverter(ChefProjetConverter chefProjetConverter ){
        this.chefProjetConverter = chefProjetConverter;
    }
    public TacheConverter getTacheConverter(){
        return this.tacheConverter;
    }
    public void setTacheConverter(TacheConverter tacheConverter ){
        this.tacheConverter = tacheConverter;
    }
    public CollaborateurConverter getCollaborateurConverter(){
        return this.collaborateurConverter;
    }
    public void setCollaborateurConverter(CollaborateurConverter collaborateurConverter ){
        this.collaborateurConverter = collaborateurConverter;
    }
    public boolean  isTypeProjet(){
        return this.typeProjet;
    }
    public void  setTypeProjet(boolean typeProjet){
        this.typeProjet = typeProjet;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isChefProjet(){
        return this.chefProjet;
    }
    public void  setChefProjet(boolean chefProjet){
        this.chefProjet = chefProjet;
    }
    public boolean  isProjetRessources(){
        return this.projetRessources ;
    }
    public void  setProjetRessources(boolean projetRessources ){
        this.projetRessources  = projetRessources ;
    }
    public boolean  isTaches(){
        return this.taches ;
    }
    public void  setTaches(boolean taches ){
        this.taches  = taches ;
    }
    public boolean  isRemarques(){
        return this.remarques ;
    }
    public void  setRemarques(boolean remarques ){
        this.remarques  = remarques ;
    }
}
