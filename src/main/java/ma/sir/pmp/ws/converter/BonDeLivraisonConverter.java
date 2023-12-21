package ma.sir.pmp.ws.converter;

import ma.sir.pmp.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.history.BonDeLivraisonHistory;
import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.ws.dto.BonDeLivraisonDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.DateUtil;

@Component
public class BonDeLivraisonConverter extends AbstractConverter<BonDeLivraison, BonDeLivraisonDto, BonDeLivraisonHistory> {
   @Autowired
   private ClientConverter clientConverter ;
   @Autowired
   private FournisseurConverter fournisseurConverter ;
   private boolean client;
   private boolean fournisseur;
    public BonDeLivraisonConverter() {
        super(BonDeLivraison.class, BonDeLivraisonDto.class, BonDeLivraisonHistory.class);
    }
    @Override
    public BonDeLivraison toItem(BonDeLivraisonDto dto) {
        if (dto == null) {
            return null;
        } else {
            BonDeLivraison item = new BonDeLivraison();
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
            if(StringUtil.isNotEmpty(dto.getDateLivraison()))
            item.setDateLivraison(DateUtil.stringEnToDate(dto.getDateLivraison()));
            if(StringUtil.isNotEmpty(dto.getLieuLivraison()))
            item.setLieuLivraison(dto.getLieuLivraison());
            if(this.client && dto.getClient()!=null)
            item.setClient(clientConverter.toItem(dto.getClient()));
            if(this.fournisseur && dto.getFournisseur()!=null)
            item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur()));
            return item;
        }
    }

    @Override
    public BonDeLivraisonDto toDto(BonDeLivraison item) {
        if (item == null) {
            return null;
        } else {
            BonDeLivraisonDto dto = new BonDeLivraisonDto();
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
            if(item.getDateLivraison()!=null)
            dto.setDateLivraison(DateUtil.dateTimeToString(item.getDateLivraison()));
            if(StringUtil.isNotEmpty(item.getLieuLivraison()))
            dto.setLieuLivraison(item.getLieuLivraison());

            dto.setClient(clientConverter.toDto(item.getClient()));
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur()));
            return dto;
        }
    }

    public ClientConverter getClientConverter() {
        return clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public FournisseurConverter getFournisseurConverter() {
        return fournisseurConverter;
    }

    public void setFournisseurConverter(FournisseurConverter fournisseurConverter) {
        this.fournisseurConverter = fournisseurConverter;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(boolean fournisseur) {
        this.fournisseur = fournisseur;
    }
}