package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.EntiteAdministrative;
import ma.sir.pmp.bean.history.EntiteAdministrativeHistory;
import ma.sir.pmp.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.pmp.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.pmp.dao.facade.core.EntiteAdministrativeDao;
import ma.sir.pmp.dao.facade.history.EntiteAdministrativeHistoryDao;
import ma.sir.pmp.dao.specification.core.EntiteAdministrativeSpecification;
import ma.sir.pmp.service.facade.admin.EntiteAdministrativeAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EntiteAdministrativeAdminServiceImpl extends AbstractServiceImpl<EntiteAdministrative,EntiteAdministrativeHistory, EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria, EntiteAdministrativeDao,
EntiteAdministrativeHistoryDao> implements EntiteAdministrativeAdminService {


    public EntiteAdministrative findByReferenceEntity(EntiteAdministrative t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EntiteAdministrative.class,EntiteAdministrativeHistory.class, EntiteAdministrativeHistoryCriteria.class, EntiteAdministrativeSpecification.class);
    }


    public EntiteAdministrativeAdminServiceImpl(EntiteAdministrativeDao dao, EntiteAdministrativeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}