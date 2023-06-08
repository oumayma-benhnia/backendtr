package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.bean.history.CategorieMaterielHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieMaterielHistoryDao extends AbstractHistoryRepository<CategorieMaterielHistory,Long> {

}
