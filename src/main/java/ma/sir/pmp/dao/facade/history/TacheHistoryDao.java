package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.TacheHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheHistoryDao extends AbstractHistoryRepository<TacheHistory,Long> {

}
