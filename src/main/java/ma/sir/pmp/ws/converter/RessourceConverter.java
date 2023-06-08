package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.RessourceHistory;
import ma.sir.pmp.bean.core.Ressource;
import ma.sir.pmp.ws.dto.RessourceDto;

@Component
public class RessourceConverter extends AbstractConverter<Ressource, RessourceDto, RessourceHistory> {

    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private MaterielConverter materielConverter ;
    @Autowired
    private EntiteAdministrativeConverter entiteAdministrativeConverter ;
    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    private boolean fournisseur;
    private boolean materiel;
    private boolean collaborateur;
    private boolean entiteAdministrative;

    public  RessourceConverter(){
        super(Ressource.class, RessourceDto.class, RessourceHistory.class);
    }

    @Override
    public Ressource toItem(RessourceDto dto) {
        if (dto == null) {
            return null;
        } else {
        Ressource item = new Ressource();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getCout()))
                item.setCout(dto.getCout());
            if(StringUtil.isNotEmpty(dto.getType()))
                item.setType(dto.getType());
            if(StringUtil.isNotEmpty(dto.getUnite()))
                item.setUnite(dto.getUnite());
            if(this.fournisseur && dto.getFournisseur()!=null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.materiel && dto.getMateriel()!=null)
                item.setMateriel(materielConverter.toItem(dto.getMateriel())) ;

            if(this.collaborateur && dto.getCollaborateur()!=null)
                item.setCollaborateur(collaborateurConverter.toItem(dto.getCollaborateur())) ;

            if(this.entiteAdministrative && dto.getEntiteAdministrative()!=null)
                item.setEntiteAdministrative(entiteAdministrativeConverter.toItem(dto.getEntiteAdministrative())) ;



        return item;
        }
    }

    @Override
    public RessourceDto toDto(Ressource item) {
        if (item == null) {
            return null;
        } else {
            RessourceDto dto = new RessourceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getCout()))
                dto.setCout(item.getCout());
            if(StringUtil.isNotEmpty(item.getType()))
                dto.setType(item.getType());
            if(StringUtil.isNotEmpty(item.getUnite()))
                dto.setUnite(item.getUnite());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.materiel && item.getMateriel()!=null) {
            dto.setMateriel(materielConverter.toDto(item.getMateriel())) ;
        }
        if(this.collaborateur && item.getCollaborateur()!=null) {
            dto.setCollaborateur(collaborateurConverter.toDto(item.getCollaborateur())) ;
        }
        if(this.entiteAdministrative && item.getEntiteAdministrative()!=null) {
            dto.setEntiteAdministrative(entiteAdministrativeConverter.toDto(item.getEntiteAdministrative())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.fournisseur = value;
        this.materiel = value;
        this.collaborateur = value;
        this.entiteAdministrative = value;
    }


    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public MaterielConverter getMaterielConverter(){
        return this.materielConverter;
    }
    public void setMaterielConverter(MaterielConverter materielConverter ){
        this.materielConverter = materielConverter;
    }
    public EntiteAdministrativeConverter getEntiteAdministrativeConverter(){
        return this.entiteAdministrativeConverter;
    }
    public void setEntiteAdministrativeConverter(EntiteAdministrativeConverter entiteAdministrativeConverter ){
        this.entiteAdministrativeConverter = entiteAdministrativeConverter;
    }
    public CollaborateurConverter getCollaborateurConverter(){
        return this.collaborateurConverter;
    }
    public void setCollaborateurConverter(CollaborateurConverter collaborateurConverter ){
        this.collaborateurConverter = collaborateurConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isMateriel(){
        return this.materiel;
    }
    public void  setMateriel(boolean materiel){
        this.materiel = materiel;
    }
    public boolean  isCollaborateur(){
        return this.collaborateur;
    }
    public void  setCollaborateur(boolean collaborateur){
        this.collaborateur = collaborateur;
    }
    public boolean  isEntiteAdministrative(){
        return this.entiteAdministrative;
    }
    public void  setEntiteAdministrative(boolean entiteAdministrative){
        this.entiteAdministrative = entiteAdministrative;
    }
}
