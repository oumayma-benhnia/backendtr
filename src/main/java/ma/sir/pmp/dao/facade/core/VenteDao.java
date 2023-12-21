package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Service;
import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VenteDao extends AbstractRepository<Vente,Long> {
    Vente findByCode(String code);
    Vente findByClientId(Long id);
    int deleteByCode(String code);
    @Query("SELECT NEW Vente (item.id,item.code) FROM Vente item")
    List<Vente> findAllOptimized();
}
