package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Collaborateur;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.history.CollaborateurHistory;
import ma.sir.pmp.bean.history.EmployeHistory;
import ma.sir.pmp.dao.criteria.core.CollaborateurCriteria;
import ma.sir.pmp.dao.criteria.core.EmployeCriteria;
import ma.sir.pmp.dao.criteria.history.CollaborateurHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.EmployeHistoryCriteria;
import ma.sir.pmp.dao.facade.core.CollaborateurDao;
import ma.sir.pmp.dao.facade.core.EmployeDao;
import ma.sir.pmp.dao.facade.history.CollaborateurHistoryDao;
import ma.sir.pmp.dao.facade.history.EmployeHistoryDao;
import ma.sir.pmp.dao.specification.core.CollaborateurSpecification;
import ma.sir.pmp.dao.specification.core.EmployeSpecification;
import ma.sir.pmp.service.facade.admin.CollaborateurAdminService;
import ma.sir.pmp.service.facade.admin.EmployeAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeAdminServiceImpl extends AbstractServiceImpl<Employe, EmployeHistory, EmployeCriteria, EmployeHistoryCriteria, EmployeDao,
        EmployeHistoryDao> implements EmployeAdminService {


    public Employe findByCodeEntity(Employe t){
        return  dao.findByCode(t.getCode());
    }
    public int deleteByNomAndPrenom(String nom, String prenom) {
        return dao.deleteByNomAndPrenom(nom, prenom);
    }


    public Employe findByNomAndPrenom(String nom, String prenom) {
        return dao.findByNomAndPrenom(nom, prenom);
    }



    public void configure() {
        super.configure(Employe.class,EmployeHistory.class, EmployeHistoryCriteria.class, EmployeSpecification.class);
    }


    public EmployeAdminServiceImpl(EmployeDao dao, EmployeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
