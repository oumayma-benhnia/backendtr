package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.FactureHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureHistoryDao extends AbstractHistoryRepository<FactureHistory,Long> {

}
