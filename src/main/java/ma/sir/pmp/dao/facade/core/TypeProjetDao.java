package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.TypeProjet;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.TypeProjet;
import java.util.List;


@Repository
public interface TypeProjetDao extends AbstractRepository<TypeProjet,Long>  {
    TypeProjet findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeProjet(item.id,item.libelle) FROM TypeProjet item")
    List<TypeProjet> findAllOptimized();
}
