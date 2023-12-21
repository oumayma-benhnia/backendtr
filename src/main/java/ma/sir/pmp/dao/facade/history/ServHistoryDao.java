package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.bean.history.ServHistory;
import ma.sir.pmp.bean.history.ServiceHistory;
import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;

public interface ServHistoryDao extends AbstractHistoryRepository<ServHistory,Long> {
}
