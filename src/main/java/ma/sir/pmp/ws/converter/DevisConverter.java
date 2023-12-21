package ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.bean.history.DevisHistory;
import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.ws.dto.DevisDto;

import java.math.BigDecimal;

@Component
public class DevisConverter extends AbstractConverter<Devis, DevisDto, DevisHistory> {

    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private ProjetConverter projetConverter;

    private boolean client;
    private boolean projet;

    public DevisConverter() {
        super(Devis.class, DevisDto.class, DevisHistory.class);
    }

    @Override
    public Devis toItem(DevisDto dto) {
        if (dto == null) {
            return null;
        } else {
            Devis item = new Devis();

            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPrixUniHT()))
                item.setPrixUniHT(dto.getPrixUniHT());
           if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
             if(StringUtil.isNotEmpty(dto.getDateEcheance()))
                item.setDateEcheance(DateUtil.stringEnToDate(dto.getDateEcheance()));
            if (dto.getClient() != null && dto.getClient().getId() != null) {
                item.setClient(clientConverter.toItem(dto.getClient()));
            }
            if (dto.getProjet() != null && dto.getProjet().getId() != null) {
                item.setProjet(projetConverter.toItem(dto.getProjet()));
            }
            return item;
        }
    }

    @Override
    public DevisDto toDto(Devis item) {
        if (item == null) {
            return null;
        } else {
            DevisDto dto = new DevisDto();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPrixUniHT()))
                item.setPrixUniHT(dto.getPrixUniHT());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(item.getDateEcheance()!=null)
                dto.setDateEcheance(DateUtil.dateTimeToString(item.getDateEcheance()));
            if (this.client && item.getClient() != null) {
                dto.setClient(clientConverter.toDto(item.getClient()));
            }

            if (this.projet && item.getProjet() != null) {
                dto.setProjet(projetConverter.toDto(item.getProjet()));
            }
            return dto;
        }
    }

    public void initObject(boolean value) {
        this.client = value;
        this.projet = value;
    }

    public ClientConverter getClientConverter() {
        return this.clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public ProjetConverter getProjetConverter() {
        return this.projetConverter;
    }

    public void setProjetConverter(ProjetConverter projetConverter) {
        this.projetConverter = projetConverter;
    }

    public boolean isClient() {
        return this.client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isProjet() {
        return this.projet;
    }

    public void setProjet(boolean projet) {
        this.projet = projet;
    }
}