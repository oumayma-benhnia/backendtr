package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Materiel;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Materiel;
import java.util.List;


@Repository
public interface MaterielDao extends AbstractRepository<Materiel,Long>  {
    Materiel findByReference(String reference);
    int deleteByReference(String reference);

    List<Materiel> findByCategorieMaterielId(Long id);
    int deleteByCategorieMaterielId(Long id);

    @Query("SELECT NEW Materiel(item.id,item.libelle) FROM Materiel item")
    List<Materiel> findAllOptimized();
}
