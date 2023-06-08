package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.EntiteAdministrativeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EntiteAdministrativeHistoryDao extends AbstractHistoryRepository<EntiteAdministrativeHistory,Long> {

}
