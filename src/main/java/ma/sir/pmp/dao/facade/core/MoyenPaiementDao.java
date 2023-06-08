package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.MoyenPaiement;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.MoyenPaiement;
import java.util.List;


@Repository
public interface MoyenPaiementDao extends AbstractRepository<MoyenPaiement,Long>  {
    MoyenPaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW MoyenPaiement(item.id,item.code) FROM MoyenPaiement item")
    List<MoyenPaiement> findAllOptimized();
}
