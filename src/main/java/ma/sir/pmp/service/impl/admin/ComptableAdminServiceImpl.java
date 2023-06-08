package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Comptable;
import ma.sir.pmp.bean.history.ComptableHistory;
import ma.sir.pmp.dao.criteria.core.ComptableCriteria;
import ma.sir.pmp.dao.criteria.history.ComptableHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ComptableDao;
import ma.sir.pmp.dao.facade.history.ComptableHistoryDao;
import ma.sir.pmp.dao.specification.core.ComptableSpecification;
import ma.sir.pmp.service.facade.admin.ComptableAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ComptableAdminServiceImpl extends AbstractServiceImpl<Comptable,ComptableHistory, ComptableCriteria, ComptableHistoryCriteria, ComptableDao,
ComptableHistoryDao> implements ComptableAdminService {


    public Comptable findByReferenceEntity(Comptable t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Comptable.class,ComptableHistory.class, ComptableHistoryCriteria.class, ComptableSpecification.class);
    }


    public ComptableAdminServiceImpl(ComptableDao dao, ComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}