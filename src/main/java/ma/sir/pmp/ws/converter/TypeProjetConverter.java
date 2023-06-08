package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.TypeProjetHistory;
import ma.sir.pmp.bean.core.TypeProjet;
import ma.sir.pmp.ws.dto.TypeProjetDto;

@Component
public class TypeProjetConverter extends AbstractConverter<TypeProjet, TypeProjetDto, TypeProjetHistory> {


    public  TypeProjetConverter(){
        super(TypeProjet.class, TypeProjetDto.class, TypeProjetHistory.class);
    }

    @Override
    public TypeProjet toItem(TypeProjetDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeProjet item = new TypeProjet();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public TypeProjetDto toDto(TypeProjet item) {
        if (item == null) {
            return null;
        } else {
            TypeProjetDto dto = new TypeProjetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
