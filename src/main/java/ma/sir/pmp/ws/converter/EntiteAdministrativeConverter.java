package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.EntiteAdministrativeHistory;
import ma.sir.pmp.bean.core.EntiteAdministrative;
import ma.sir.pmp.ws.dto.EntiteAdministrativeDto;

@Component
public class EntiteAdministrativeConverter extends AbstractConverter<EntiteAdministrative, EntiteAdministrativeDto, EntiteAdministrativeHistory> {


    public  EntiteAdministrativeConverter(){
        super(EntiteAdministrative.class, EntiteAdministrativeDto.class, EntiteAdministrativeHistory.class);
    }

    @Override
    public EntiteAdministrative toItem(EntiteAdministrativeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntiteAdministrative item = new EntiteAdministrative();
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
    public EntiteAdministrativeDto toDto(EntiteAdministrative item) {
        if (item == null) {
            return null;
        } else {
            EntiteAdministrativeDto dto = new EntiteAdministrativeDto();
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
