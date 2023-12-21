package ma.sir.pmp.ws.converter;

import ma.sir.pmp.zynerator.util.ListUtil;
import ma.sir.pmp.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.history.AchatHistory;
import ma.sir.pmp.bean.core.Achat;
import ma.sir.pmp.ws.dto.AchatDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto, AchatHistory> {

    @Autowired
    private MaterielConverter materielConverter;
    @Autowired
    private FournisseurConverter fournisseurConverter;
    private boolean materiels;
    private boolean fournisseur;
    public AchatConverter() {
        super(Achat.class, AchatDto.class, AchatHistory.class);
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
            Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.materiels && ListUtil.isNotEmpty(dto.getMateriels()))
            item.setMateriels(materielConverter.toItem(dto.getMateriels()));
            if(this.fournisseur && dto.getFournisseur()!=null)
            item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur()));
            if(StringUtil.isNotEmpty(dto.getDateAchat()))
            item.setDateAchat(DateUtil.stringEnToDate(dto.getDateAchat()));
            return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(this.materiels && ListUtil.isNotEmpty(item.getMateriels())){
                materielConverter.init(true);
                materielConverter.setAchat(false);
                dto.setMateriels(materielConverter.toDto(item.getMateriels()));
                materielConverter.setAchat(true);

            }
            if (this.fournisseur && item.getFournisseur() != null) {
                dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur()));
            }

            dto.setDateAchat(DateUtil.dateTimeToString(item.getDateAchat()));
            return dto;
        }
    }

    public MaterielConverter getMaterielConverter() {
        return materielConverter;
    }

    public void setMaterielConverter(MaterielConverter materielConverter) {
        this.materielConverter = materielConverter;
    }

    public FournisseurConverter getFournisseurConverter() {
        return fournisseurConverter;
    }

    public void setFournisseurConverter(FournisseurConverter fournisseurConverter) {
        this.fournisseurConverter = fournisseurConverter;
    }

    public boolean isMateriels() {
        return materiels;
    }

    public void setMateriels(boolean materiels) {
        this.materiels = materiels;
    }

    public boolean isFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(boolean fournisseur) {
        this.fournisseur = fournisseur;
    }
    public void initList(boolean value) {
        this.materiels = value;

    }

    public void initObject(boolean value) {
        this.fournisseur = value;

    }
}