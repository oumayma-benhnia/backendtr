package ma.sir.pmp.ws.converter;

import ma.sir.pmp.zynerator.util.StringUtil;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.history.BonDeCommandeHistory;
import ma.sir.pmp.bean.core.BonDeCommande;
import ma.sir.pmp.ws.dto.BonDeCommandeDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;

@Component
public class BonDeCommandeConverter extends AbstractConverter<BonDeCommande, BonDeCommandeDto, BonDeCommandeHistory> {

    public BonDeCommandeConverter() {
        super(BonDeCommande.class, BonDeCommandeDto.class, BonDeCommandeHistory.class);
    }

    @Override
    public BonDeCommande toItem(BonDeCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
            BonDeCommande item = new BonDeCommande();
            if(StringUtil.isNotEmpty(item.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
            item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
            item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
            item.setDescription(dto.getDescription());
            item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getPrixUniHT()))
            item.setPrixUniHT(dto.getPrixUniHT());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
            item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getDateEcheance()))
            item.setDateEcheance(DateUtil.stringEnToDate(dto.getDateEcheance()));
            return item;
        }
    }

    @Override
    public BonDeCommandeDto toDto(BonDeCommande item) {
        if (item == null) {
            return null;
        } else {
            BonDeCommandeDto dto = new BonDeCommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
            dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
            dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
            dto.setDescription(item.getDescription());
            dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrixUniHT()))
            dto.setPrixUniHT(item.getPrixUniHT());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
           if(item.getDateEcheance()!=null)
            dto.setDateEcheance(DateUtil.dateTimeToString(item.getDateEcheance()));
            return dto;
        }
    }

}