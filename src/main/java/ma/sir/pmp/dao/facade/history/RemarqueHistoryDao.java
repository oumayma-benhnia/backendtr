package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.RemarqueHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface RemarqueHistoryDao extends AbstractHistoryRepository<RemarqueHistory,Long> {

}
