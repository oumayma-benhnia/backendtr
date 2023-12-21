package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BonDeLivraisonDao extends AbstractRepository<BonDeLivraison,Long> {
    List<BonDeLivraison> findByClientId(Long id);
    List<BonDeLivraison> findByFournisseurId(Long id);

    BonDeLivraison findByDateLivraison(LocalDateTime dateLivraison);
    BonDeLivraison findByReference(String reference);
    int deleteByReference(String reference);
    @Query("SELECT NEW BonDeLivraison (item.id,item.libelle) FROM BonDeLivraison item")
    List<BonDeLivraison> findAllOptimized();


}
