package ma.sir.pmp.ws.converter;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.bean.history.AbsenceHistory;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.bean.history.ProjetHistory;
import ma.sir.pmp.ws.dto.AbsenceDto;
import ma.sir.pmp.ws.dto.FactureDto;
import ma.sir.pmp.ws.dto.ProjetDto;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import org.springframework.stereotype.Component;
import ma.sir.pmp.zynerator.util.DateUtil;
import ma.sir.pmp.zynerator.util.ListUtil;
import ma.sir.pmp.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class AbsenceConverter extends AbstractConverter<Absence, AbsenceDto, AbsenceHistory> {
    @Autowired
    private EmployeConverter employeConverter ;
    @Autowired
    private ChefProjetConverter chefProjetConverter ;
    @Autowired
    private StagaireConverter stagaireConverter ;
      private boolean employes;
       private boolean stagaires;
       private boolean chefProjets;
    public  AbsenceConverter(){
        super(Absence.class, AbsenceDto.class, AbsenceHistory.class);
        init(true);
    }
    @Override
    public Absence toItem(AbsenceDto dto) {
        if (dto == null) {
            return null;
        } else {
            Absence item = new Absence();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.employes && ListUtil.isNotEmpty(dto.getEmployes()))
                item.setEmployes(employeConverter.toItem(dto.getEmployes()));
            if(this.chefProjets && ListUtil.isNotEmpty(dto.getChefProjets()))
                item.setChefProjets(chefProjetConverter.toItem(dto.getChefProjets()));
            if(this.stagaires && ListUtil.isNotEmpty(dto.getStagaires()))
            item.setStagaires(stagaireConverter.toItem(dto.getStagaires()));
            if(StringUtil.isNotEmpty(dto.getDateAbsence()))
            item.setDateAbsence(DateUtil.stringEnToDate(dto.getDateAbsence()));
            if(StringUtil.isNotEmpty(dto.getJustification()))
            item.setJustification(dto.getJustification());
            return item;
        }
    }

    @Override
    public AbsenceDto toDto(Absence item) {
        if (item == null) {
            return null;
        } else {
            AbsenceDto dto = new AbsenceDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
            dto.setCode(item.getCode());
            if(this.employes && ListUtil.isNotEmpty(item.getEmployes())){
                employeConverter.init(true);
                employeConverter.setAbsence(false);
                dto.setEmployes(employeConverter.toDto(item.getEmployes()));
                employeConverter.setAbsence(true);
         }

            if(this.chefProjets && ListUtil.isNotEmpty(item.getChefProjets())){
                chefProjetConverter.init(true);
                chefProjetConverter.setAbsence(false);
                dto.setChefProjets(chefProjetConverter.toDto(item.getChefProjets()));
                chefProjetConverter.setAbsence(true);
            }
            if(this.stagaires && ListUtil.isNotEmpty(item.getStagaires())){
                stagaireConverter.init(true);
                stagaireConverter.setAbsence(false);
                dto.setStagaires(stagaireConverter.toDto(item.getStagaires()));
                stagaireConverter.setAbsence(true);
            }
            if(item.getDateAbsence()!=null)
            dto.setDateAbsence(DateUtil.dateTimeToString(item.getDateAbsence()));
            if(StringUtil.isNotEmpty(item.getJustification()))
            dto.setJustification(item.getJustification());
            return dto;
        }
    }

    public void initList(boolean value) {
        this.employes = value;
        this.stagaires = value;
        this.chefProjets = value;
    }

    public EmployeConverter getEmployeConverter() {
        return employeConverter;
    }

    public void setEmployeConverter(EmployeConverter employeConverter) {
        this.employeConverter = employeConverter;
    }

    public ChefProjetConverter getChefProjetConverter() {
        return chefProjetConverter;
    }

    public void setChefProjetConverter(ChefProjetConverter chefProjetConverter) {
        this.chefProjetConverter = chefProjetConverter;
    }

    public StagaireConverter getStagaireConverter() {
        return stagaireConverter;
    }

    public void setStagaireConverter(StagaireConverter stagaireConverter) {
        this.stagaireConverter = stagaireConverter;
    }

    public boolean isEmployes() {
        return employes;
    }

    public void setEmployes(boolean employes) {
        this.employes = employes;
    }

    public boolean isStagaires() {
        return stagaires;
    }

    public void setStagaires(boolean stagaires) {
        this.stagaires = stagaires;
    }

    public boolean isChefProjets() {
        return chefProjets;
    }

    public void setChefProjets(boolean chefProjets) {
        this.chefProjets = chefProjets;
    }

    public void initObject(boolean value) {
    }
}
