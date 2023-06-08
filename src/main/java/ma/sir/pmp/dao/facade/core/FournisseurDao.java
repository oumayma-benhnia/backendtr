package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Fournisseur;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Fournisseur;
import java.util.List;


@Repository
public interface FournisseurDao extends AbstractRepository<Fournisseur,Long>  {
    Fournisseur findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Fournisseur(item.id,item.code) FROM Fournisseur item")
    List<Fournisseur> findAllOptimized();
}
