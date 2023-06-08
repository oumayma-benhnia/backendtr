package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.ChefProjet;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.ChefProjet;
import java.util.List;


@Repository
public interface ChefProjetDao extends AbstractRepository<ChefProjet,Long>  {
    ChefProjet findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ChefProjet(item.id,item.code) FROM ChefProjet item")
    List<ChefProjet> findAllOptimized();
}
