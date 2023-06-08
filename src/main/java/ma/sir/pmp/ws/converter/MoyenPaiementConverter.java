package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.MoyenPaiementHistory;
import ma.sir.pmp.bean.core.MoyenPaiement;
import ma.sir.pmp.ws.dto.MoyenPaiementDto;

@Component
public class MoyenPaiementConverter extends AbstractConverter<MoyenPaiement, MoyenPaiementDto, MoyenPaiementHistory> {


    public  MoyenPaiementConverter(){
        super(MoyenPaiement.class, MoyenPaiementDto.class, MoyenPaiementHistory.class);
    }

    @Override
    public MoyenPaiement toItem(MoyenPaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        MoyenPaiement item = new MoyenPaiement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateRemarque()))
                item.setDateRemarque(DateUtil.stringEnToDate(dto.getDateRemarque()));


        return item;
        }
    }

    @Override
    public MoyenPaiementDto toDto(MoyenPaiement item) {
        if (item == null) {
            return null;
        } else {
            MoyenPaiementDto dto = new MoyenPaiementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getDateRemarque()!=null)
                dto.setDateRemarque(DateUtil.dateTimeToString(item.getDateRemarque()));


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
