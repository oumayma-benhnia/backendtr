package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.pmp.bean.core.Projet;

import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.RemarqueHistory;
import ma.sir.pmp.bean.core.Remarque;
import ma.sir.pmp.ws.dto.RemarqueDto;

@Component
public class RemarqueConverter extends AbstractConverter<Remarque, RemarqueDto, RemarqueHistory> {

    @Autowired
    private ProjetConverter projetConverter ;
    private boolean projet;

    public  RemarqueConverter(){
        super(Remarque.class, RemarqueDto.class, RemarqueHistory.class);
    }

    @Override
    public Remarque toItem(RemarqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Remarque item = new Remarque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateRemarque()))
                item.setDateRemarque(DateUtil.stringEnToDate(dto.getDateRemarque()));
            if(dto.getProjet() != null && dto.getProjet().getId() != null){
                item.setProjet(new Projet());
                item.getProjet().setId(dto.getProjet().getId());
            }



        return item;
        }
    }

    @Override
    public RemarqueDto toDto(Remarque item) {
        if (item == null) {
            return null;
        } else {
            RemarqueDto dto = new RemarqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getDateRemarque()!=null)
                dto.setDateRemarque(DateUtil.dateTimeToString(item.getDateRemarque()));
        if(this.projet && item.getProjet()!=null) {
            dto.setProjet(projetConverter.toDto(item.getProjet())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.projet = value;
    }


    public ProjetConverter getProjetConverter(){
        return this.projetConverter;
    }
    public void setProjetConverter(ProjetConverter projetConverter ){
        this.projetConverter = projetConverter;
    }
    public boolean  isProjet(){
        return this.projet;
    }
    public void  setProjet(boolean projet){
        this.projet = projet;
    }
}
