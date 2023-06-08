package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.dao.criteria.core.ProjetCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface ProjetAdminService extends  IService<Projet,ProjetCriteria, ProjetHistoryCriteria>  {

    List<Projet> findByTypeProjetId(Long id);
    int deleteByTypeProjetId(Long id);
    List<Projet> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Projet> findByChefProjetId(Long id);
    int deleteByChefProjetId(Long id);



}
