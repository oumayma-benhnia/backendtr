package ma.sir.pmp.ws.converter;

import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.zynerator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.bean.history.VenteHistory;
import ma.sir.pmp.ws.dto.VenteDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.StringUtil;

@Component
public class VenteConverter extends AbstractConverter<Vente, VenteDto, VenteHistory> {

    @Autowired
    private TypeVenteConverter typeVenteConverter;
    private boolean typeVente;
    @Autowired
    private ClientConverter clientConverter;
    private boolean client ;

    public VenteConverter() {
        super(Vente.class, VenteDto.class, VenteHistory.class);
    }

    @Override
    public Vente toItem(VenteDto dto) {
        if (dto == null) {
            return null;
        } else {
            Vente item = new Vente();
            item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
            item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
            item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateVente()))
            item.setDateVente(DateUtil.stringEnToDate(dto.getDateVente()));

            if (dto.getTypeVente() != null) {
                item.setTypeVente(typeVenteConverter.toItem(dto.getTypeVente()));
            }

            if (dto.getClient() != null) {
                item.setClient(clientConverter.toItem(dto.getClient()));
            }

            // Set other fields as needed

            return item;
        }
    }

    @Override
    public VenteDto toDto(Vente item) {
        if (item == null) {
            return null;
        } else {
            VenteDto dto = new VenteDto();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
            dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
            dto.setLibelle(item.getLibelle());
            if(item.getDateVente()!=null)
            dto.setDateVente(DateUtil.dateTimeToString(item.getDateVente()));
          if (item.getTypeVente() != null) {
                dto.setTypeVente(typeVenteConverter.toDto(item.getTypeVente()));
            }

            if (item.getClient() != null) {
                dto.setClient(clientConverter.toDto(item.getClient()));
            }


            return dto;
        }
    }

    public void initObject(boolean value) {
        this.client=value;
        this.typeVente=value;


    }

    public TypeVenteConverter getTypeVenteConverter() {
        return typeVenteConverter;
    }

    public void setTypeVenteConverter(TypeVenteConverter typeVenteConverter) {
        this.typeVenteConverter = typeVenteConverter;
    }

    public boolean isTypeVente() {
        return typeVente;
    }

    public void setTypeVente(boolean typeVente) {
        this.typeVente = typeVente;
    }

    public ClientConverter getClientConverter() {
        return clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }
}