package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.CategorieMateriel;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.CategorieMateriel;
import java.util.List;


@Repository
public interface CategorieMaterielDao extends AbstractRepository<CategorieMateriel,Long>  {
    CategorieMateriel findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW CategorieMateriel(item.id,item.libelle) FROM CategorieMateriel item")
    List<CategorieMateriel> findAllOptimized();
}
