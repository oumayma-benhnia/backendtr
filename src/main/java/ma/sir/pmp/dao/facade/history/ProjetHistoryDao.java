package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.ProjetHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetHistoryDao extends AbstractHistoryRepository<ProjetHistory,Long> {

}
