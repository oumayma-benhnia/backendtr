package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.EntiteAdministrative;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.EntiteAdministrative;
import java.util.List;


@Repository
public interface EntiteAdministrativeDao extends AbstractRepository<EntiteAdministrative,Long>  {
    EntiteAdministrative findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EntiteAdministrative(item.id,item.libelle) FROM EntiteAdministrative item")
    List<EntiteAdministrative> findAllOptimized();
}
