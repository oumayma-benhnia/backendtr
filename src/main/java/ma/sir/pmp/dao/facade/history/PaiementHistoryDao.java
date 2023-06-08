package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.PaiementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementHistoryDao extends AbstractHistoryRepository<PaiementHistory,Long> {

}
