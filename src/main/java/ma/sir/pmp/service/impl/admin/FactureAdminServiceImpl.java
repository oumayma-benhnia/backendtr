package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.dao.facade.core.FactureDao;
import ma.sir.pmp.dao.facade.history.FactureHistoryDao;
import ma.sir.pmp.dao.specification.core.FactureSpecification;
import ma.sir.pmp.service.facade.admin.FactureAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.ComptableAdminService ;
import ma.sir.pmp.service.facade.admin.ProjetAdminService ;


import java.util.List;
@Service
public class FactureAdminServiceImpl extends AbstractServiceImpl<Facture,FactureHistory, FactureCriteria, FactureHistoryCriteria, FactureDao,
FactureHistoryDao> implements FactureAdminService {


    public Facture findByReferenceEntity(Facture t){
        return  dao.findByReference(t.getReference());
    }

    public List<Facture> findByComptableId(Long id){
        return dao.findByComptableId(id);
    }
    public int deleteByComptableId(Long id){
        return dao.deleteByComptableId(id);
    }
    public List<Facture> findByProjetId(Long id){
        return dao.findByProjetId(id);
    }
    public int deleteByProjetId(Long id){
        return dao.deleteByProjetId(id);
    }



    public void configure() {
        super.configure(Facture.class,FactureHistory.class, FactureHistoryCriteria.class, FactureSpecification.class);
    }

    @Autowired
    private ComptableAdminService comptableService ;
    @Autowired
    private ProjetAdminService projetService ;

    public FactureAdminServiceImpl(FactureDao dao, FactureHistoryDao historyDao) {
        super(dao, historyDao);
    }

}