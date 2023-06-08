package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Facture;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Facture;
import java.util.List;


@Repository
public interface FactureDao extends AbstractRepository<Facture,Long>  {
    Facture findByReference(String reference);
    int deleteByReference(String reference);

    List<Facture> findByComptableId(Long id);
    int deleteByComptableId(Long id);
    List<Facture> findByProjetId(Long id);
    int deleteByProjetId(Long id);

    @Query("SELECT NEW Facture(item.id,item.libelle) FROM Facture item")
    List<Facture> findAllOptimized();
}
