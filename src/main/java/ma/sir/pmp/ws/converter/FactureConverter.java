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
    private ComptableConverter comptableConverter ;
    @Autowired
    private ProjetConverter projetConverter ;
    private boolean comptable;
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
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getDateEcheance()))
                item.setDateEcheance(DateUtil.stringEnToDate(dto.getDateEcheance()));
            if(this.comptable && dto.getComptable()!=null)
                item.setComptable(comptableConverter.toItem(dto.getComptable())) ;

            if(dto.getProjet() != null && dto.getProjet().getId() != null){
                item.setProjet(new Projet());
                item.getProjet().setId(dto.getProjet().getId());
            }



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
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(item.getDateEcheance()!=null)
                dto.setDateEcheance(DateUtil.dateTimeToString(item.getDateEcheance()));
        if(this.comptable && item.getComptable()!=null) {
            dto.setComptable(comptableConverter.toDto(item.getComptable())) ;
        }
        if(this.projet && item.getProjet()!=null) {
            dto.setProjet(projetConverter.toDto(item.getProjet())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.comptable = value;
        this.projet = value;
    }


    public ComptableConverter getComptableConverter(){
        return this.comptableConverter;
    }
    public void setComptableConverter(ComptableConverter comptableConverter ){
        this.comptableConverter = comptableConverter;
    }
    public ProjetConverter getProjetConverter(){
        return this.projetConverter;
    }
    public void setProjetConverter(ProjetConverter projetConverter ){
        this.projetConverter = projetConverter;
    }
    public boolean  isComptable(){
        return this.comptable;
    }
    public void  setComptable(boolean comptable){
        this.comptable = comptable;
    }
    public boolean  isProjet(){
        return this.projet;
    }
    public void  setProjet(boolean projet){
        this.projet = projet;
    }
}
