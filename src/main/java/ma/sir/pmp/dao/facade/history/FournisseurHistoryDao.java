package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.FournisseurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurHistoryDao extends AbstractHistoryRepository<FournisseurHistory,Long> {

}
