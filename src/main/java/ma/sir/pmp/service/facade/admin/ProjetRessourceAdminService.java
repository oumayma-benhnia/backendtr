package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.ProjetRessource;
import ma.sir.pmp.dao.criteria.core.ProjetRessourceCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetRessourceHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface ProjetRessourceAdminService extends  IService<ProjetRessource,ProjetRessourceCriteria, ProjetRessourceHistoryCriteria>  {

    List<ProjetRessource> findByRessourceId(Long id);
    int deleteByRessourceId(Long id);
    List<ProjetRessource> findByProjetId(Long id);
    int deleteByProjetId(Long id);



}
