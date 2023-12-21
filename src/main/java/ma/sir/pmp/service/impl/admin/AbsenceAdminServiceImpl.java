package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.bean.history.AbsenceHistory;
import ma.sir.pmp.dao.criteria.core.AbsenceCriteria;
import ma.sir.pmp.dao.criteria.history.AbsenceHistoryCriteria;
import ma.sir.pmp.dao.facade.core.AbsenceDao;
import ma.sir.pmp.dao.facade.history.AbsenceHistoryDao;
import ma.sir.pmp.dao.specification.core.AbsenceSpecification;
import ma.sir.pmp.service.facade.admin.AbsenceAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AbsenceAdminServiceImpl extends AbstractServiceImpl<Absence, AbsenceHistory, AbsenceCriteria, AbsenceHistoryCriteria, AbsenceDao,
        AbsenceHistoryDao> implements AbsenceAdminService {

    public Absence findByCodeEntity(Absence t) {
        return dao.findByCode(t.getCode());
    }

    public Absence findByDateAbsenceEntity(Absence t) {
        return dao.findByDateAbsence(t.getDateAbsence());
    }


    // Add any additional methods specific to AbsenceAdminService

    public void configure() {
        super.configure(Absence.class, AbsenceHistory.class, AbsenceHistoryCriteria.class, AbsenceSpecification.class);
    }

    public AbsenceAdminServiceImpl(AbsenceDao dao, AbsenceHistoryDao historyDao) {
        super(dao, historyDao);
    }


    public List<Absence> findByNames(String employeeName, String chefProjetName, String stagiaireName) {
        return dao.findByNames(employeeName,chefProjetName,stagiaireName);
    }


    public Absence findByDateAbsence(LocalDateTime dateAbsence) {
        return dao.findByDateAbsence(dateAbsence);
    }
}