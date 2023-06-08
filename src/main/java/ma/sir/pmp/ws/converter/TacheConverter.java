package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.TacheHistory;
import ma.sir.pmp.bean.core.Tache;
import ma.sir.pmp.ws.dto.TacheDto;

@Component
public class TacheConverter extends AbstractConverter<Tache, TacheDto, TacheHistory> {

    @Autowired
    private CollaborateurConverter collaborateurConverter ;
    private boolean collaborateur;
    private boolean projet;

    public  TacheConverter(){
        super(Tache.class, TacheDto.class, TacheHistory.class);
    }

    @Override
    public Tache toItem(TacheDto dto) {
        if (dto == null) {
            return null;
        } else {
        Tache item = new Tache();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getTele()))
                item.setTele(dto.getTele());
            if(StringUtil.isNotEmpty(dto.getTitre()))
                item.setTitre(dto.getTitre());
            if(StringUtil.isNotEmpty(dto.getSalaire()))
                item.setSalaire(dto.getSalaire());
            if(this.collaborateur && dto.getCollaborateur()!=null)
                item.setCollaborateur(collaborateurConverter.toItem(dto.getCollaborateur())) ;



        return item;
        }
    }

    @Override
    public TacheDto toDto(Tache item) {
        if (item == null) {
            return null;
        } else {
            TacheDto dto = new TacheDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getTele()))
                dto.setTele(item.getTele());
            if(StringUtil.isNotEmpty(item.getTitre()))
                dto.setTitre(item.getTitre());
            if(StringUtil.isNotEmpty(item.getSalaire()))
                dto.setSalaire(item.getSalaire());
        if(this.collaborateur && item.getCollaborateur()!=null) {
            dto.setCollaborateur(collaborateurConverter.toDto(item.getCollaborateur())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.collaborateur = value;
    }


    public CollaborateurConverter getCollaborateurConverter(){
        return this.collaborateurConverter;
    }
    public void setCollaborateurConverter(CollaborateurConverter collaborateurConverter ){
        this.collaborateurConverter = collaborateurConverter;
    }
    public boolean  isCollaborateur(){
        return this.collaborateur;
    }
    public void  setCollaborateur(boolean collaborateur){
        this.collaborateur = collaborateur;
    }

    public void setProjet(boolean projet) {
        this.projet = projet;
    }
}
