package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Tache;
import ma.sir.pmp.dao.criteria.core.TacheCriteria;
import ma.sir.pmp.dao.criteria.history.TacheHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface TacheAdminService extends  IService<Tache,TacheCriteria, TacheHistoryCriteria>  {

    List<Tache> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);


    List<Tache> findByProjetId(Long id);

    int deleteByProjetId(Long id);
}
