package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.bean.history.BonDeCommandeHistory;
import ma.sir.pmp.bean.history.BonDeLivraisonHistory;
import ma.sir.pmp.dao.criteria.core.BonDeCommandeCriteria;
import ma.sir.pmp.dao.criteria.core.BonDeLivraisonCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeLivraisonHistoryCriteria;
import ma.sir.pmp.dao.facade.core.BonDeCommandeDao;
import ma.sir.pmp.dao.facade.core.BonDeLivraisonDao;
import ma.sir.pmp.dao.facade.history.BonDeCommandeHistoryDao;
import ma.sir.pmp.dao.facade.history.BonDeLivraisonHistoryDao;
import ma.sir.pmp.dao.specification.core.BonDeCommandeSpecification;
import ma.sir.pmp.dao.specification.core.BonDeLivraisonSpecification;
import ma.sir.pmp.service.facade.admin.BonDeCommandeAdminService;
import ma.sir.pmp.service.facade.admin.BonDeLivraisonAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BonDeLivraisonAdminServiceImpl   extends AbstractServiceImpl<BonDeLivraison, BonDeLivraisonHistory, BonDeLivraisonCriteria, BonDeLivraisonHistoryCriteria, BonDeLivraisonDao,
        BonDeLivraisonHistoryDao> implements BonDeLivraisonAdminService {


    public BonDeLivraison findByReferenceEntity(BonDeLivraison t) {
        return dao.findByReference(t.getReference());
    }

    public List<BonDeLivraison> findByClientId(Long id) {
        return dao.findByClientId(id);
    }
    public List<BonDeLivraison> findByFournisseurId(Long id) {
        return dao.findByFournisseurId(id);
    }


    public BonDeLivraison findByDateLivraison(LocalDateTime dateLivraison) {

        return dao.findByDateLivraison(dateLivraison);
    }



    public void configure() {
        super.configure(BonDeLivraison.class, BonDeLivraisonHistory.class, BonDeLivraisonHistoryCriteria.class, BonDeLivraisonSpecification.class);
    }


    @Autowired
    private ClientAdminServiceImpl clientService;

@Autowired
    private FournisseurAdminServiceImpl fournisseurService;


    public BonDeLivraisonAdminServiceImpl(BonDeLivraisonDao dao, BonDeLivraisonHistoryDao historyDao) {
        super(dao, historyDao);
    }
}
