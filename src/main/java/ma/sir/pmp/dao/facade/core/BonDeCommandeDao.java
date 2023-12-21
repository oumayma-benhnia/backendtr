package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.BonDeCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BonDeCommandeDao extends AbstractRepository<BonDeCommande,Long> {
    BonDeCommande findByReference(String reference);
    int deleteByReference(String reference);
    List<BonDeCommande> findByClientId(Long id);
    @Query("SELECT NEW BonDeCommande (item.id,item.libelle) FROM BonDeCommande item")
    List<BonDeCommande> findAllOptimized();
}
