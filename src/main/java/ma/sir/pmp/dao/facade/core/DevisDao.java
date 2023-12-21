package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DevisDao extends AbstractRepository<Devis,Long> {
    Devis findByReference (String reference);
    int deleteByReference(String reference);
    List<Devis> findByProjetId(Long id);
    int deleteByProjetId(Long id);

    @Query("SELECT NEW Devis (item.id,item.libelle) FROM Devis item")
    List<Devis> findAllOptimized();


}
