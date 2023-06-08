package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.TypeDeclarationHistory;
import ma.sir.pmp.bean.core.TypeDeclaration;
import ma.sir.pmp.ws.dto.TypeDeclarationDto;

@Component
public class TypeDeclarationConverter extends AbstractConverter<TypeDeclaration, TypeDeclarationDto, TypeDeclarationHistory> {


    public  TypeDeclarationConverter(){
        super(TypeDeclaration.class, TypeDeclarationDto.class, TypeDeclarationHistory.class);
    }

    @Override
    public TypeDeclaration toItem(TypeDeclarationDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeDeclaration item = new TypeDeclaration();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());


        return item;
        }
    }

    @Override
    public TypeDeclarationDto toDto(TypeDeclaration item) {
        if (item == null) {
            return null;
        } else {
            TypeDeclarationDto dto = new TypeDeclarationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
