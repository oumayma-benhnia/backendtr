package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.bean.history.FournisseurHistory;
import ma.sir.pmp.dao.criteria.core.FournisseurCriteria;
import ma.sir.pmp.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.pmp.dao.facade.core.FournisseurDao;
import ma.sir.pmp.dao.facade.history.FournisseurHistoryDao;
import ma.sir.pmp.dao.specification.core.FournisseurSpecification;
import ma.sir.pmp.service.facade.admin.FournisseurAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur,FournisseurHistory, FournisseurCriteria, FournisseurHistoryCriteria, FournisseurDao,
FournisseurHistoryDao> implements FournisseurAdminService {


    public Fournisseur findByReferenceEntity(Fournisseur t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Fournisseur.class,FournisseurHistory.class, FournisseurHistoryCriteria.class, FournisseurSpecification.class);
    }


    public FournisseurAdminServiceImpl(FournisseurDao dao, FournisseurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}