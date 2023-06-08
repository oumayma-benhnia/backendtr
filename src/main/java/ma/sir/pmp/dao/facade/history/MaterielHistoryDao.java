package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.MaterielHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielHistoryDao extends AbstractHistoryRepository<MaterielHistory,Long> {

}
