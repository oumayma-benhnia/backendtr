package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.ChefProjetHistory;
import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.ws.dto.ChefProjetDto;

@Component
public class ChefProjetConverter extends AbstractConverter<ChefProjet, ChefProjetDto, ChefProjetHistory> {


    public  ChefProjetConverter(){
        super(ChefProjet.class, ChefProjetDto.class, ChefProjetHistory.class);
    }

    @Override
    public ChefProjet toItem(ChefProjetDto dto) {
        if (dto == null) {
            return null;
        } else {
        ChefProjet item = new ChefProjet();
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
            if(StringUtil.isNotEmpty(dto.getSalaire()))
                item.setSalaire(dto.getSalaire());


        return item;
        }
    }

    @Override
    public ChefProjetDto toDto(ChefProjet item) {
        if (item == null) {
            return null;
        } else {
            ChefProjetDto dto = new ChefProjetDto();
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
            if(StringUtil.isNotEmpty(item.getSalaire()))
                dto.setSalaire(item.getSalaire());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
