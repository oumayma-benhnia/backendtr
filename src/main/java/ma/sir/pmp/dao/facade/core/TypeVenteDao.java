package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Service;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeVenteDao extends AbstractRepository<TypeVente,Long> {
    TypeVente findByLibelle(String libelle);
    TypeVente findByCode(String code);
    int deleteByCode(String code);
    @Query("SELECT NEW TypeVente (item.id,item.code) FROM TypeVente item")
    List<TypeVente> findAllOptimized();
}
