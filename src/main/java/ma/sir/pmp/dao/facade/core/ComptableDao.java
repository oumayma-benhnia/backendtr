package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Comptable;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Comptable;
import java.util.List;


@Repository
public interface ComptableDao extends AbstractRepository<Comptable,Long>  {
    Comptable findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Comptable(item.id,item.code) FROM Comptable item")
    List<Comptable> findAllOptimized();
}
