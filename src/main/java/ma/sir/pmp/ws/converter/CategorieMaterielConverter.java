package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.CategorieMaterielHistory;
import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.ws.dto.CategorieMaterielDto;

@Component
public class CategorieMaterielConverter extends AbstractConverter<CategorieMateriel, CategorieMaterielDto, CategorieMaterielHistory> {


    public  CategorieMaterielConverter(){
        super(CategorieMateriel.class, CategorieMaterielDto.class, CategorieMaterielHistory.class);
    }

    @Override
    public CategorieMateriel toItem(CategorieMaterielDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieMateriel item = new CategorieMateriel();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());


        return item;
        }
    }

    @Override
    public CategorieMaterielDto toDto(CategorieMateriel item) {
        if (item == null) {
            return null;
        } else {
            CategorieMaterielDto dto = new CategorieMaterielDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
