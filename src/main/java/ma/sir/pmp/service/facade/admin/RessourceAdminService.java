package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Ressource;
import ma.sir.pmp.dao.criteria.core.RessourceCriteria;
import ma.sir.pmp.dao.criteria.history.RessourceHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface RessourceAdminService extends  IService<Ressource,RessourceCriteria, RessourceHistoryCriteria>  {

    List<Ressource> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    List<Ressource> findByMaterielId(Long id);
    int deleteByMaterielId(Long id);
    List<Ressource> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);
    List<Ressource> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);



}
