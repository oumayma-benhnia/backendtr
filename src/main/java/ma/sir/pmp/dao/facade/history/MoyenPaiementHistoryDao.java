package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.MoyenPaiementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyenPaiementHistoryDao extends AbstractHistoryRepository<MoyenPaiementHistory,Long> {

}
