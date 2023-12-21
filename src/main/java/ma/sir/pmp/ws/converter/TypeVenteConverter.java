package ma.sir.pmp.ws.converter;

import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.bean.history.TypeVenteHistory;
import ma.sir.pmp.ws.dto.TypeVenteDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.StringUtil;

@Component
public class TypeVenteConverter extends AbstractConverter<TypeVente, TypeVenteDto, TypeVenteHistory> {

    public TypeVenteConverter() {
        super(TypeVente.class, TypeVenteDto.class, TypeVenteHistory.class);
    }

    @Override
    public TypeVente toItem(TypeVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
            TypeVente item = new TypeVente();
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
    public TypeVenteDto toDto(TypeVente item) {
        if (item == null) {
            return null;
        } else {
            TypeVenteDto dto = new TypeVenteDto();
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