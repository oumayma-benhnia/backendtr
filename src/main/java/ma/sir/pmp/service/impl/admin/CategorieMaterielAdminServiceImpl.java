package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.history.CategorieMaterielHistory;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.facade.core.CategorieMaterielDao;
import ma.sir.pmp.dao.facade.history.CategorieMaterielHistoryDao;
import ma.sir.pmp.dao.specification.core.CategorieMaterielSpecification;
import ma.sir.pmp.service.facade.admin.CategorieMaterielAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class CategorieMaterielAdminServiceImpl extends AbstractServiceImpl<CategorieMateriel,CategorieMaterielHistory, CategorieMaterielCriteria, CategorieMaterielHistoryCriteria, CategorieMaterielDao,
CategorieMaterielHistoryDao> implements CategorieMaterielAdminService {


    public CategorieMateriel findByReferenceEntity(CategorieMateriel t){
        return  dao.findByReference(t.getReference());
    }




    public void configure() {
        super.configure(CategorieMateriel.class,CategorieMaterielHistory.class, CategorieMaterielHistoryCriteria.class, CategorieMaterielSpecification.class);
    }


    public CategorieMaterielAdminServiceImpl(CategorieMaterielDao dao, CategorieMaterielHistoryDao historyDao) {
        super(dao, historyDao);
    }

}