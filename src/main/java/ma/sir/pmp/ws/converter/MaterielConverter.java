package  ma.sir.pmp.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.bean.history.MaterielHistory;
import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.ws.dto.MaterielDto;

@Component
public class MaterielConverter extends AbstractConverter<Materiel, MaterielDto, MaterielHistory> {

    @Autowired
    private CategorieMaterielConverter categorieMaterielConverter ;
    private boolean categorieMateriel;

    public  MaterielConverter(){
        super(Materiel.class, MaterielDto.class, MaterielHistory.class);
    }

    @Override
    public Materiel toItem(MaterielDto dto) {
        if (dto == null) {
            return null;
        } else {
        Materiel item = new Materiel();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getPrix()))
                item.setPrix(dto.getPrix());
            if(this.categorieMateriel && dto.getCategorieMateriel()!=null)
                item.setCategorieMateriel(categorieMaterielConverter.toItem(dto.getCategorieMateriel())) ;



        return item;
        }
    }

    @Override
    public MaterielDto toDto(Materiel item) {
        if (item == null) {
            return null;
        } else {
            MaterielDto dto = new MaterielDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getPrix()))
                dto.setPrix(item.getPrix());
        if(this.categorieMateriel && item.getCategorieMateriel()!=null) {
            dto.setCategorieMateriel(categorieMaterielConverter.toDto(item.getCategorieMateriel())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.categorieMateriel = value;
    }


    public CategorieMaterielConverter getCategorieMaterielConverter(){
        return this.categorieMaterielConverter;
    }
    public void setCategorieMaterielConverter(CategorieMaterielConverter categorieMaterielConverter ){
        this.categorieMaterielConverter = categorieMaterielConverter;
    }
    public boolean  isCategorieMateriel(){
        return this.categorieMateriel;
    }
    public void  setCategorieMateriel(boolean categorieMateriel){
        this.categorieMateriel = categorieMateriel;
    }
}
