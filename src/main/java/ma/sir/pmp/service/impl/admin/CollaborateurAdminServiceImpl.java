package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Collaborateur;
import ma.sir.pmp.bean.history.CollaborateurHistory;
import ma.sir.pmp.dao.criteria.core.CollaborateurCriteria;
import ma.sir.pmp.dao.criteria.history.CollaborateurHistoryCriteria;
import ma.sir.pmp.dao.facade.core.CollaborateurDao;
import ma.sir.pmp.dao.facade.history.CollaborateurHistoryDao;
import ma.sir.pmp.dao.specification.core.CollaborateurSpecification;
import ma.sir.pmp.service.facade.admin.CollaborateurAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class CollaborateurAdminServiceImpl extends AbstractServiceImpl<Collaborateur,CollaborateurHistory, CollaborateurCriteria, CollaborateurHistoryCriteria, CollaborateurDao,
CollaborateurHistoryDao> implements CollaborateurAdminService {


    public Collaborateur findByReferenceEntity(Collaborateur t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Collaborateur.class,CollaborateurHistory.class, CollaborateurHistoryCriteria.class, CollaborateurSpecification.class);
    }


    public CollaborateurAdminServiceImpl(CollaborateurDao dao, CollaborateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}