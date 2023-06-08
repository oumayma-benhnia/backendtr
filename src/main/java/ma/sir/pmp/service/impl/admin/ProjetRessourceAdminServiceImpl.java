package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.ProjetRessource;
import ma.sir.pmp.bean.history.ProjetRessourceHistory;
import ma.sir.pmp.dao.criteria.core.ProjetRessourceCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetRessourceHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ProjetRessourceDao;
import ma.sir.pmp.dao.facade.history.ProjetRessourceHistoryDao;
import ma.sir.pmp.dao.specification.core.ProjetRessourceSpecification;
import ma.sir.pmp.service.facade.admin.ProjetRessourceAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.ProjetAdminService ;
import ma.sir.pmp.service.facade.admin.RessourceAdminService ;


import java.util.List;
@Service
public class ProjetRessourceAdminServiceImpl extends AbstractServiceImpl<ProjetRessource,ProjetRessourceHistory, ProjetRessourceCriteria, ProjetRessourceHistoryCriteria, ProjetRessourceDao,
ProjetRessourceHistoryDao> implements ProjetRessourceAdminService {


    public ProjetRessource findByReferenceEntity(ProjetRessource t){
        return  dao.findByCode(t.getCode());
    }

    public List<ProjetRessource> findByRessourceId(Long id){
        return dao.findByRessourceId(id);
    }
    public int deleteByRessourceId(Long id){
        return dao.deleteByRessourceId(id);
    }
    public List<ProjetRessource> findByProjetId(Long id){
        return dao.findByProjetId(id);
    }
    public int deleteByProjetId(Long id){
        return dao.deleteByProjetId(id);
    }



    public void configure() {
        super.configure(ProjetRessource.class,ProjetRessourceHistory.class, ProjetRessourceHistoryCriteria.class, ProjetRessourceSpecification.class);
    }

    @Autowired
    private ProjetAdminService projetService ;
    @Autowired
    private RessourceAdminService ressourceService ;

    public ProjetRessourceAdminServiceImpl(ProjetRessourceDao dao, ProjetRessourceHistoryDao historyDao) {
        super(dao, historyDao);
    }

}