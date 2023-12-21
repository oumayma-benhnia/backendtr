
package ma.sir.pmp.ws.converter;

import org.springframework.stereotype.Component;
import ma.sir.pmp.bean.core.Stagaire;
import ma.sir.pmp.bean.history.StagaireHistory;
import ma.sir.pmp.ws.dto.StagaireDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.util.StringUtil;

    @Component
    public class StagaireConverter extends AbstractConverter<Stagaire, StagaireDto, StagaireHistory> {
private boolean absence ;
        public StagaireConverter() {
            super(Stagaire.class, StagaireDto.class, StagaireHistory.class);
        }

        @Override
        public Stagaire toItem(StagaireDto dto) {
            if (dto == null) {
                return null;
            } else {
                Stagaire item = new Stagaire();
                if(StringUtil.isNotEmpty(dto.getId()))
                    item.setId(dto.getId());
                if(StringUtil.isNotEmpty(dto.getCode()))
                    item.setCode(dto.getCode());
                if(StringUtil.isNotEmpty(dto.getNom()))
                    item.setNom(dto.getNom());
                if(StringUtil.isNotEmpty(dto.getPrenom()))
                    item.setPrenom(dto.getPrenom());
                if(StringUtil.isNotEmpty(dto.getEmail()))
                    item.setEmail(dto.getEmail());
                if(StringUtil.isNotEmpty(dto.getTele()))
                    item.setTele(dto.getTele());
                if(StringUtil.isNotEmpty(dto.getFonction()))
                    item.setFonction(dto.getFonction());
                return item;
            }
        }

        @Override
        public StagaireDto toDto(Stagaire item) {
            if (item == null) {
                return null;
            } else {
                StagaireDto dto = new StagaireDto();
                if(StringUtil.isNotEmpty(item.getId()))
                    dto.setId(item.getId());
                if(StringUtil.isNotEmpty(item.getCode()))
                    dto.setCode(item.getCode());
                if(StringUtil.isNotEmpty(item.getNom()))
                    dto.setNom(item.getNom());
                if(StringUtil.isNotEmpty(item.getPrenom()))
                    dto.setPrenom(item.getPrenom());
                if(StringUtil.isNotEmpty(item.getEmail()))
                    dto.setEmail(item.getEmail());
                if(StringUtil.isNotEmpty(item.getTele()))
                    dto.setTele(item.getTele());
                if(StringUtil.isNotEmpty(item.getFonction()))
                    dto.setFonction(item.getFonction());

                return dto;
            }
        }

        public boolean isAbsence() {
            return absence;
        }

        public void setAbsence(boolean absence) {
            this.absence = absence;
        }

        public void initObject(boolean value) {

        }
    }

