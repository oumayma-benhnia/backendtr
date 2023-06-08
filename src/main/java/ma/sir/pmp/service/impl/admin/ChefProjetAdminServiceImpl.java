package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.bean.history.ChefProjetHistory;
import ma.sir.pmp.dao.criteria.core.ChefProjetCriteria;
import ma.sir.pmp.dao.criteria.history.ChefProjetHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ChefProjetDao;
import ma.sir.pmp.dao.facade.history.ChefProjetHistoryDao;
import ma.sir.pmp.dao.specification.core.ChefProjetSpecification;
import ma.sir.pmp.service.facade.admin.ChefProjetAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ChefProjetAdminServiceImpl extends AbstractServiceImpl<ChefProjet,ChefProjetHistory, ChefProjetCriteria, ChefProjetHistoryCriteria, ChefProjetDao,
ChefProjetHistoryDao> implements ChefProjetAdminService {


    public ChefProjet findByReferenceEntity(ChefProjet t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(ChefProjet.class,ChefProjetHistory.class, ChefProjetHistoryCriteria.class, ChefProjetSpecification.class);
    }


    public ChefProjetAdminServiceImpl(ChefProjetDao dao, ChefProjetHistoryDao historyDao) {
        super(dao, historyDao);
    }

}