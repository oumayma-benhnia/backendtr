package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Tache;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Tache;
import java.util.List;


@Repository
public interface TacheDao extends AbstractRepository<Tache,Long>  {
    Tache findByCode(String code);
    int deleteByCode(String code);

    List<Tache> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);

    @Query("SELECT NEW Tache(item.id,item.code) FROM Tache item")
    List<Tache> findAllOptimized();
}
