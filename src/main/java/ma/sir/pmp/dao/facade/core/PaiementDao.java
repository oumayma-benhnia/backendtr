package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Paiement;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Paiement;
import java.util.List;


@Repository
public interface PaiementDao extends AbstractRepository<Paiement,Long>  {
    Paiement findByCode(String code);
    int deleteByCode(String code);

    List<Paiement> findByFactureId(Long id);
    int deleteByFactureId(Long id);
    List<Paiement> findByMoyenPaiementId(Long id);
    int deleteByMoyenPaiementId(Long id);

    @Query("SELECT NEW Paiement(item.id,item.code) FROM Paiement item")
    List<Paiement> findAllOptimized();
}
