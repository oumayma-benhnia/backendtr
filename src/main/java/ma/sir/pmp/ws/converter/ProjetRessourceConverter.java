package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.pmp.bean.core.Projet;

import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.ProjetRessourceHistory;
import ma.sir.pmp.bean.core.ProjetRessource;
import ma.sir.pmp.ws.dto.ProjetRessourceDto;

@Component
public class ProjetRessourceConverter extends AbstractConverter<ProjetRessource, ProjetRessourceDto, ProjetRessourceHistory> {

    @Autowired
    private ProjetConverter projetConverter ;
    @Autowired
    private RessourceConverter ressourceConverter ;
    private boolean ressource;
    private boolean projet;

    public  ProjetRessourceConverter(){
        super(ProjetRessource.class, ProjetRessourceDto.class, ProjetRessourceHistory.class);
    }

    @Override
    public ProjetRessource toItem(ProjetRessourceDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProjetRessource item = new ProjetRessource();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(this.ressource && dto.getRessource()!=null)
                item.setRessource(ressourceConverter.toItem(dto.getRessource())) ;

            if(dto.getProjet() != null && dto.getProjet().getId() != null){
                item.setProjet(new Projet());
                item.getProjet().setId(dto.getProjet().getId());
            }



        return item;
        }
    }

    @Override
    public ProjetRessourceDto toDto(ProjetRessource item) {
        if (item == null) {
            return null;
        } else {
            ProjetRessourceDto dto = new ProjetRessourceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.ressource && item.getRessource()!=null) {
            dto.setRessource(ressourceConverter.toDto(item.getRessource())) ;
        }
        if(this.projet && item.getProjet()!=null) {
            dto.setProjet(projetConverter.toDto(item.getProjet())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.ressource = value;
        this.projet = value;
    }


    public ProjetConverter getProjetConverter(){
        return this.projetConverter;
    }
    public void setProjetConverter(ProjetConverter projetConverter ){
        this.projetConverter = projetConverter;
    }
    public RessourceConverter getRessourceConverter(){
        return this.ressourceConverter;
    }
    public void setRessourceConverter(RessourceConverter ressourceConverter ){
        this.ressourceConverter = ressourceConverter;
    }
    public boolean  isRessource(){
        return this.ressource;
    }
    public void  setRessource(boolean ressource){
        this.ressource = ressource;
    }
    public boolean  isProjet(){
        return this.projet;
    }
    public void  setProjet(boolean projet){
        this.projet = projet;
    }
}
