package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.BonDeCommande;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.history.BonDeCommandeHistory;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.dao.criteria.core.BonDeCommandeCriteria;
import ma.sir.pmp.dao.facade.core.BonDeCommandeDao;
import ma.sir.pmp.dao.facade.core.FactureDao;
import ma.sir.pmp.dao.facade.history.BonDeCommandeHistoryDao;
import ma.sir.pmp.dao.facade.history.FactureHistoryDao;
import ma.sir.pmp.dao.specification.core.BonDeCommandeSpecification;
import ma.sir.pmp.dao.specification.core.FactureSpecification;
import ma.sir.pmp.service.facade.admin.BonDeCommandeAdminService;
import ma.sir.pmp.service.facade.admin.FactureAdminService;
import ma.sir.pmp.service.facade.admin.ProjetAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonDeCommandeAdminServiceImpl  extends AbstractServiceImpl<BonDeCommande, BonDeCommandeHistory, BonDeCommandeCriteria, BonDeCommandeHistoryCriteria, BonDeCommandeDao,
        BonDeCommandeHistoryDao> implements BonDeCommandeAdminService {


    public BonDeCommande findByReferenceEntity(BonDeCommande t) {
        return dao.findByReference(t.getReference());
    }

    public List<BonDeCommande> findByClientId(Long id) {
        return dao.findByClientId(id);
    }




    public void configure() {
        super.configure(BonDeCommande.class, BonDeCommandeHistory.class, BonDeCommandeHistoryCriteria.class, BonDeCommandeSpecification.class);
    }


    @Autowired
    private ClientAdminServiceImpl clientService;

    public BonDeCommandeAdminServiceImpl(BonDeCommandeDao dao, BonDeCommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }
}
