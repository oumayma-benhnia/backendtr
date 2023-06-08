package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.TypeProjetHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProjetHistoryDao extends AbstractHistoryRepository<TypeProjetHistory,Long> {

}
