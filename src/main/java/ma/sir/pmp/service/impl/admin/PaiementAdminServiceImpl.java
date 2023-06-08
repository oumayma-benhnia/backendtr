package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Paiement;
import ma.sir.pmp.bean.history.PaiementHistory;
import ma.sir.pmp.dao.criteria.core.PaiementCriteria;
import ma.sir.pmp.dao.criteria.history.PaiementHistoryCriteria;
import ma.sir.pmp.dao.facade.core.PaiementDao;
import ma.sir.pmp.dao.facade.history.PaiementHistoryDao;
import ma.sir.pmp.dao.specification.core.PaiementSpecification;
import ma.sir.pmp.service.facade.admin.PaiementAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.MoyenPaiementAdminService ;
import ma.sir.pmp.service.facade.admin.FactureAdminService ;


import java.util.List;
@Service
public class PaiementAdminServiceImpl extends AbstractServiceImpl<Paiement,PaiementHistory, PaiementCriteria, PaiementHistoryCriteria, PaiementDao,
PaiementHistoryDao> implements PaiementAdminService {


    public Paiement findByReferenceEntity(Paiement t){
        return  dao.findByCode(t.getCode());
    }

    public List<Paiement> findByFactureId(Long id){
        return dao.findByFactureId(id);
    }
    public int deleteByFactureId(Long id){
        return dao.deleteByFactureId(id);
    }
    public List<Paiement> findByMoyenPaiementId(Long id){
        return dao.findByMoyenPaiementId(id);
    }
    public int deleteByMoyenPaiementId(Long id){
        return dao.deleteByMoyenPaiementId(id);
    }



    public void configure() {
        super.configure(Paiement.class,PaiementHistory.class, PaiementHistoryCriteria.class, PaiementSpecification.class);
    }

    @Autowired
    private MoyenPaiementAdminService moyenPaiementService ;
    @Autowired
    private FactureAdminService factureService ;

    public PaiementAdminServiceImpl(PaiementDao dao, PaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}