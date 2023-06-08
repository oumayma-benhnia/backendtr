package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.ProjetRessource;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.ProjetRessource;
import java.util.List;


@Repository
public interface ProjetRessourceDao extends AbstractRepository<ProjetRessource,Long>  {
    ProjetRessource findByCode(String code);
    int deleteByCode(String code);

    List<ProjetRessource> findByRessourceId(Long id);
    int deleteByRessourceId(Long id);
    List<ProjetRessource> findByProjetId(Long id);
    int deleteByProjetId(Long id);

    @Query("SELECT NEW ProjetRessource(item.id,item.code) FROM ProjetRessource item")
    List<ProjetRessource> findAllOptimized();
}
