package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.DeclarationHistory;
import ma.sir.pmp.bean.core.Declaration;
import ma.sir.pmp.ws.dto.DeclarationDto;

@Component
public class DeclarationConverter extends AbstractConverter<Declaration, DeclarationDto, DeclarationHistory> {

    @Autowired
    private TypeDeclarationConverter typeDeclarationConverter ;
    private boolean typeDeclaration;

    public  DeclarationConverter(){
        super(Declaration.class, DeclarationDto.class, DeclarationHistory.class);
    }

    @Override
    public Declaration toItem(DeclarationDto dto) {
        if (dto == null) {
            return null;
        } else {
        Declaration item = new Declaration();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.typeDeclaration && dto.getTypeDeclaration()!=null)
                item.setTypeDeclaration(typeDeclarationConverter.toItem(dto.getTypeDeclaration())) ;



        return item;
        }
    }

    @Override
    public DeclarationDto toDto(Declaration item) {
        if (item == null) {
            return null;
        } else {
            DeclarationDto dto = new DeclarationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
        if(this.typeDeclaration && item.getTypeDeclaration()!=null) {
            dto.setTypeDeclaration(typeDeclarationConverter.toDto(item.getTypeDeclaration())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.typeDeclaration = value;
    }


    public TypeDeclarationConverter getTypeDeclarationConverter(){
        return this.typeDeclarationConverter;
    }
    public void setTypeDeclarationConverter(TypeDeclarationConverter typeDeclarationConverter ){
        this.typeDeclarationConverter = typeDeclarationConverter;
    }
    public boolean  isTypeDeclaration(){
        return this.typeDeclaration;
    }
    public void  setTypeDeclaration(boolean typeDeclaration){
        this.typeDeclaration = typeDeclaration;
    }
}
