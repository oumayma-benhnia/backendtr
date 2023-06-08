package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Projet;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Projet;
import java.util.List;


@Repository
public interface ProjetDao extends AbstractRepository<Projet,Long>  {
    Projet findByCode(String code);
    int deleteByCode(String code);

    List<Projet> findByTypeProjetId(Long id);
    int deleteByTypeProjetId(Long id);
    List<Projet> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Projet> findByChefProjetId(Long id);
    int deleteByChefProjetId(Long id);

    @Query("SELECT NEW Projet(item.id,item.code) FROM Projet item")
    List<Projet> findAllOptimized();
}
