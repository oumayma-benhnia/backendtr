package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Ressource;
import ma.sir.pmp.bean.history.RessourceHistory;
import ma.sir.pmp.dao.criteria.core.RessourceCriteria;
import ma.sir.pmp.dao.criteria.history.RessourceHistoryCriteria;
import ma.sir.pmp.dao.facade.core.RessourceDao;
import ma.sir.pmp.dao.facade.history.RessourceHistoryDao;
import ma.sir.pmp.dao.specification.core.RessourceSpecification;
import ma.sir.pmp.service.facade.admin.RessourceAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.FournisseurAdminService ;
import ma.sir.pmp.service.facade.admin.MaterielAdminService ;
import ma.sir.pmp.service.facade.admin.EntiteAdministrativeAdminService ;
import ma.sir.pmp.service.facade.admin.CollaborateurAdminService ;


import java.util.List;
@Service
public class RessourceAdminServiceImpl extends AbstractServiceImpl<Ressource,RessourceHistory, RessourceCriteria, RessourceHistoryCriteria, RessourceDao,
RessourceHistoryDao> implements RessourceAdminService {



    public List<Ressource> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public List<Ressource> findByMaterielId(Long id){
        return dao.findByMaterielId(id);
    }
    public int deleteByMaterielId(Long id){
        return dao.deleteByMaterielId(id);
    }
    public List<Ressource> findByCollaborateurId(Long id){
        return dao.findByCollaborateurId(id);
    }
    public int deleteByCollaborateurId(Long id){
        return dao.deleteByCollaborateurId(id);
    }
    public List<Ressource> findByEntiteAdministrativeId(Long id){
        return dao.findByEntiteAdministrativeId(id);
    }
    public int deleteByEntiteAdministrativeId(Long id){
        return dao.deleteByEntiteAdministrativeId(id);
    }



    public void configure() {
        super.configure(Ressource.class,RessourceHistory.class, RessourceHistoryCriteria.class, RessourceSpecification.class);
    }

    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private MaterielAdminService materielService ;
    @Autowired
    private EntiteAdministrativeAdminService entiteAdministrativeService ;
    @Autowired
    private CollaborateurAdminService collaborateurService ;

    public RessourceAdminServiceImpl(RessourceDao dao, RessourceHistoryDao historyDao) {
        super(dao, historyDao);
    }

}