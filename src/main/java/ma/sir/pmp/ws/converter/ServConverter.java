package ma.sir.pmp.ws.converter;

import ma.sir.pmp.bean.core.TypeProjet;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.bean.history.ServHistory;
import ma.sir.pmp.ws.dto.ServDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.StringUtil;

@Component
public class ServConverter extends AbstractConverter<Serv, ServDto, ServHistory> {

    public ServConverter() {
        super(Serv.class, ServDto.class, ServHistory.class);
    }

    @Override
    public Serv toItem(ServDto dto) {
        if (dto == null) {
            return null;
        } else {
            Serv item = new Serv();
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
    public ServDto toDto(Serv item) {
        if (item == null) {
            return null;
        } else {
            ServDto dto = new ServDto();
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