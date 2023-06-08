package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.RessourceHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceHistoryDao extends AbstractHistoryRepository<RessourceHistory,Long> {

}
