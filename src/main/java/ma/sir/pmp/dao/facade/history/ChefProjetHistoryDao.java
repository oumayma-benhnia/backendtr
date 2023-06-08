package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.ChefProjetHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefProjetHistoryDao extends AbstractHistoryRepository<ChefProjetHistory,Long> {

}
