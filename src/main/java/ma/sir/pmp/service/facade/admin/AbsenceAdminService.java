package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.dao.criteria.core.AbsenceCriteria;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.history.AbsenceHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AbsenceAdminService extends IService<Absence, AbsenceCriteria, AbsenceHistoryCriteria> {
    List<Absence> findByNames(
            @Param("employeeName") String employeeName,
            @Param("chefProjetName") String chefProjetName,
            @Param("stagiaireName") String stagiaireName
    );
    Absence findByDateAbsence (LocalDateTime dateAbsence);
}
