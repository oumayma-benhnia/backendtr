package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.history.DevisHistory;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.dao.criteria.core.DevisCriteria;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.dao.criteria.history.DevisHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.dao.facade.core.DevisDao;
import ma.sir.pmp.dao.facade.core.FactureDao;
import ma.sir.pmp.dao.facade.history.DevisHistoryDao;
import ma.sir.pmp.dao.facade.history.FactureHistoryDao;
import ma.sir.pmp.dao.specification.core.DevisSpecification;
import ma.sir.pmp.dao.specification.core.FactureSpecification;
import ma.sir.pmp.service.facade.admin.DevisAdminService;
import ma.sir.pmp.service.facade.admin.FactureAdminService;
import ma.sir.pmp.service.facade.admin.ProjetAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
 public class DevisAdminServiceImpl extends AbstractServiceImpl<Devis, DevisHistory, DevisCriteria, DevisHistoryCriteria, DevisDao ,
         DevisHistoryDao> implements DevisAdminService {


    public Devis findByReferenceEntity(Devis t){
        return  dao.findByReference(t.getReference());
    }
    public List<Devis> findByProjetId(Long id){
        return dao.findByProjetId(id);
    }
    public int deleteByProjetId(Long id){
        return dao.deleteByProjetId(id);
    }



    public void configure() {
        super.configure(Devis.class,DevisHistory.class, DevisHistoryCriteria.class, DevisSpecification.class);
    }


    @Autowired
    private ProjetAdminService projetService ;

    public DevisAdminServiceImpl(DevisDao dao, DevisHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
