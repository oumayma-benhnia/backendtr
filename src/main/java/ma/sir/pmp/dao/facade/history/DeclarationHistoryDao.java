package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.DeclarationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationHistoryDao extends AbstractHistoryRepository<DeclarationHistory,Long> {

}
