package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.MoyenPaiement;
import ma.sir.pmp.bean.history.MoyenPaiementHistory;
import ma.sir.pmp.dao.criteria.core.MoyenPaiementCriteria;
import ma.sir.pmp.dao.criteria.history.MoyenPaiementHistoryCriteria;
import ma.sir.pmp.dao.facade.core.MoyenPaiementDao;
import ma.sir.pmp.dao.facade.history.MoyenPaiementHistoryDao;
import ma.sir.pmp.dao.specification.core.MoyenPaiementSpecification;
import ma.sir.pmp.service.facade.admin.MoyenPaiementAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class MoyenPaiementAdminServiceImpl extends AbstractServiceImpl<MoyenPaiement,MoyenPaiementHistory, MoyenPaiementCriteria, MoyenPaiementHistoryCriteria, MoyenPaiementDao,
MoyenPaiementHistoryDao> implements MoyenPaiementAdminService {


    public MoyenPaiement findByReferenceEntity(MoyenPaiement t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(MoyenPaiement.class,MoyenPaiementHistory.class, MoyenPaiementHistoryCriteria.class, MoyenPaiementSpecification.class);
    }


    public MoyenPaiementAdminServiceImpl(MoyenPaiementDao dao, MoyenPaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}