package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.CollaborateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurHistoryDao extends AbstractHistoryRepository<CollaborateurHistory,Long> {

}
