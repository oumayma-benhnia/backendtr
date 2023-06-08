package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Ressource;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RessourceDao extends AbstractRepository<Ressource,Long>  {

    List<Ressource> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    List<Ressource> findByMaterielId(Long id);
    int deleteByMaterielId(Long id);
    List<Ressource> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);
    List<Ressource> findByEntiteAdministrativeId(Long id);
    int deleteByEntiteAdministrativeId(Long id);

}
