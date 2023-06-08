package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.ComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptableHistoryDao extends AbstractHistoryRepository<ComptableHistory,Long> {

}
