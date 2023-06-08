package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.PaiementHistory;
import ma.sir.pmp.bean.core.Paiement;
import ma.sir.pmp.ws.dto.PaiementDto;

@Component
public class PaiementConverter extends AbstractConverter<Paiement, PaiementDto, PaiementHistory> {

    @Autowired
    private MoyenPaiementConverter moyenPaiementConverter ;
    @Autowired
    private FactureConverter factureConverter ;
    private boolean facture;
    private boolean moyenPaiement;

    public  PaiementConverter(){
        super(Paiement.class, PaiementDto.class, PaiementHistory.class);
    }

    @Override
    public Paiement toItem(PaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        Paiement item = new Paiement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(this.facture && dto.getFacture()!=null)
                item.setFacture(factureConverter.toItem(dto.getFacture())) ;

            if(this.moyenPaiement && dto.getMoyenPaiement()!=null)
                item.setMoyenPaiement(moyenPaiementConverter.toItem(dto.getMoyenPaiement())) ;



        return item;
        }
    }

    @Override
    public PaiementDto toDto(Paiement item) {
        if (item == null) {
            return null;
        } else {
            PaiementDto dto = new PaiementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.facture && item.getFacture()!=null) {
            dto.setFacture(factureConverter.toDto(item.getFacture())) ;
        }
        if(this.moyenPaiement && item.getMoyenPaiement()!=null) {
            dto.setMoyenPaiement(moyenPaiementConverter.toDto(item.getMoyenPaiement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.facture = value;
        this.moyenPaiement = value;
    }


    public MoyenPaiementConverter getMoyenPaiementConverter(){
        return this.moyenPaiementConverter;
    }
    public void setMoyenPaiementConverter(MoyenPaiementConverter moyenPaiementConverter ){
        this.moyenPaiementConverter = moyenPaiementConverter;
    }
    public FactureConverter getFactureConverter(){
        return this.factureConverter;
    }
    public void setFactureConverter(FactureConverter factureConverter ){
        this.factureConverter = factureConverter;
    }
    public boolean  isFacture(){
        return this.facture;
    }
    public void  setFacture(boolean facture){
        this.facture = facture;
    }
    public boolean  isMoyenPaiement(){
        return this.moyenPaiement;
    }
    public void  setMoyenPaiement(boolean moyenPaiement){
        this.moyenPaiement = moyenPaiement;
    }
}
