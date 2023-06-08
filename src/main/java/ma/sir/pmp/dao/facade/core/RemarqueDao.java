package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Remarque;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Remarque;
import java.util.List;


@Repository
public interface RemarqueDao extends AbstractRepository<Remarque,Long>  {
    Remarque findByCode(String code);
    int deleteByCode(String code);

    List<Remarque> findByProjetId(Long id);
    int deleteByProjetId(Long id);

    @Query("SELECT NEW Remarque(item.id,item.code) FROM Remarque item")
    List<Remarque> findAllOptimized();
}
