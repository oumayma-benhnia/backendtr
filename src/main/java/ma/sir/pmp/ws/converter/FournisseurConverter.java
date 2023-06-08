package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.FournisseurHistory;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.ws.dto.FournisseurDto;

@Component
public class FournisseurConverter extends AbstractConverter<Fournisseur, FournisseurDto, FournisseurHistory> {


    public  FournisseurConverter(){
        super(Fournisseur.class, FournisseurDto.class, FournisseurHistory.class);
    }

    @Override
    public Fournisseur toItem(FournisseurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Fournisseur item = new Fournisseur();
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
            if(StringUtil.isNotEmpty(dto.getSociete()))
                item.setSociete(dto.getSociete());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());


        return item;
        }
    }

    @Override
    public FournisseurDto toDto(Fournisseur item) {
        if (item == null) {
            return null;
        } else {
            FournisseurDto dto = new FournisseurDto();
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
            if(StringUtil.isNotEmpty(item.getSociete()))
                dto.setSociete(item.getSociete());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
