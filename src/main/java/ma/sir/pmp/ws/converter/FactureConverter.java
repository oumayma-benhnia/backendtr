package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.pmp.bean.core.Projet;

import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.ws.dto.FactureDto;

@Component
public class FactureConverter extends AbstractConverter<Facture, FactureDto, FactureHistory> {


    @Autowired
    private ProjetConverter projetConverter ;
    @Autowired
    private ClientConverter clientConverter;
    private boolean client;
    private boolean projet;

    public  FactureConverter(){
        super(Facture.class, FactureDto.class, FactureHistory.class);
    }

    @Override
    public Facture toItem(FactureDto dto) {
        if (dto == null) {
            return null;
        } else {
        Facture item = new Facture();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaireHT()))
                item.setPrixUnitaireHT(dto.getPrixUnitaireHT());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getDateEcheance()))
                item.setDateEcheance(DateUtil.stringEnToDate(dto.getDateEcheance()));


            if(dto.getProjet() != null && dto.getProjet().getId() != null){
                item.setProjet(new Projet());
                item.getProjet().setId(dto.getProjet().getId());
            }
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;
            return item;
        }
    }

    @Override
    public FactureDto toDto(Facture item) {
        if (item == null) {
            return null;
        } else {
            FactureDto dto = new FactureDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getPrixUnitaireHT()))
                dto.setPrixUnitaireHT(item.getPrixUnitaireHT());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(item.getDateEcheance()!=null)
                dto.setDateEcheance(DateUtil.dateTimeToString(item.getDateEcheance()));

        if(this.projet && item.getProjet()!=null) {
            dto.setProjet(projetConverter.toDto(item.getProjet())) ;
        }
            if(this.client && item.getClient()!=null) {
                dto.setClient(clientConverter.toDto(item.getClient())) ;
            }


        return dto;
        }
    }


    public void initObject(boolean value) {

        this.projet = value;
        this.client = value;
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

    public ProjetConverter getProjetConverter(){
        return this.projetConverter;
    }
    public void setProjetConverter(ProjetConverter projetConverter ){
        this.projetConverter = projetConverter;
    }


    public boolean  isProjet(){
        return this.projet;
    }
    public void  setProjet(boolean projet){
        this.projet = projet;
    }
}
