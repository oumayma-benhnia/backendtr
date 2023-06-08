package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.bean.history.ProjetHistory;
import ma.sir.pmp.dao.criteria.core.ProjetCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ProjetDao;
import ma.sir.pmp.dao.facade.history.ProjetHistoryDao;
import ma.sir.pmp.dao.specification.core.ProjetSpecification;
import ma.sir.pmp.service.facade.admin.ProjetAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.pmp.bean.core.ProjetRessource;
import ma.sir.pmp.bean.core.Tache;
import ma.sir.pmp.bean.core.Remarque;

import ma.sir.pmp.service.facade.admin.RemarqueAdminService ;
import ma.sir.pmp.service.facade.admin.ChefProjetAdminService ;
import ma.sir.pmp.service.facade.admin.TacheAdminService ;
import ma.sir.pmp.service.facade.admin.TypeProjetAdminService ;
import ma.sir.pmp.service.facade.admin.ProjetRessourceAdminService ;
import ma.sir.pmp.service.facade.admin.ClientAdminService ;


import java.util.List;
@Service
public class ProjetAdminServiceImpl extends AbstractServiceImpl<Projet,ProjetHistory, ProjetCriteria, ProjetHistoryCriteria, ProjetDao,
ProjetHistoryDao> implements ProjetAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Projet create(Projet t) {
        super.create(t);
        if (t.getProjetRessources() != null) {
                t.getProjetRessources().forEach(element-> {
                    element.setProjet(t);
                    projetRessourceService.create(element);
            });
        }
        if (t.getTaches() != null) {
                t.getTaches().forEach(element-> {
                    element.setProjet(t);
                    tacheService.create(element);
            });
        }
        if (t.getRemarques() != null) {
                t.getRemarques().forEach(element-> {
                    element.setProjet(t);
                    remarqueService.create(element);
            });
        }
        return t;
    }

    public Projet findWithAssociatedLists(Long id){
        Projet result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setProjetRessources(projetRessourceService.findByProjetId(id));
            result.setTaches(tacheService.findByProjetId(id));
            result.setRemarques(remarqueService.findByProjetId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        projetRessourceService.deleteByProjetId(id);
        tacheService.deleteByProjetId(id);
        remarqueService.deleteByProjetId(id);
    }


    public void updateWithAssociatedLists(Projet projet){
    if(projet !=null && projet.getId() != null){
            List<List<ProjetRessource>> resultProjetRessources= projetRessourceService.getToBeSavedAndToBeDeleted(projetRessourceService.findByProjetId(projet.getId()),projet.getProjetRessources());
            projetRessourceService.delete(resultProjetRessources.get(1));
            ListUtil.emptyIfNull(resultProjetRessources.get(0)).forEach(e -> e.setProjet(projet));
            projetRessourceService.update(resultProjetRessources.get(0),true);
            List<List<Tache>> resultTaches= tacheService.getToBeSavedAndToBeDeleted(tacheService.findByProjetId(projet.getId()),projet.getTaches());
            tacheService.delete(resultTaches.get(1));
            ListUtil.emptyIfNull(resultTaches.get(0)).forEach(e -> e.setProjet(projet));
            tacheService.update(resultTaches.get(0),true);
            List<List<Remarque>> resultRemarques= remarqueService.getToBeSavedAndToBeDeleted(remarqueService.findByProjetId(projet.getId()),projet.getRemarques());
            remarqueService.delete(resultRemarques.get(1));
            ListUtil.emptyIfNull(resultRemarques.get(0)).forEach(e -> e.setProjet(projet));
            remarqueService.update(resultRemarques.get(0),true);
    }
    }

    public Projet findByReferenceEntity(Projet t){
        return  dao.findByCode(t.getCode());
    }

    public List<Projet> findByTypeProjetId(Long id){
        return dao.findByTypeProjetId(id);
    }
    public int deleteByTypeProjetId(Long id){
        return dao.deleteByTypeProjetId(id);
    }
    public List<Projet> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Projet> findByChefProjetId(Long id){
        return dao.findByChefProjetId(id);
    }
    public int deleteByChefProjetId(Long id){
        return dao.deleteByChefProjetId(id);
    }



    public void configure() {
        super.configure(Projet.class,ProjetHistory.class, ProjetHistoryCriteria.class, ProjetSpecification.class);
    }

    @Autowired
    private RemarqueAdminService remarqueService ;
    @Autowired
    private ChefProjetAdminService chefProjetService ;
    @Autowired
    private TacheAdminService tacheService ;
    @Autowired
    private TypeProjetAdminService typeProjetService ;
    @Autowired
    private ProjetRessourceAdminService projetRessourceService ;
    @Autowired
    private ClientAdminService clientService ;

    public ProjetAdminServiceImpl(ProjetDao dao, ProjetHistoryDao historyDao) {
        super(dao, historyDao);
    }

}