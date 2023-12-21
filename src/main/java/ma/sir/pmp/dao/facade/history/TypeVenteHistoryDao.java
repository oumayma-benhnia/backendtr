package ma.sir.pmp.dao.facade.history;

import ma.sir.pmp.bean.history.TypeVenteHistory;
import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeVenteHistoryDao extends AbstractHistoryRepository<TypeVenteHistory,Long> {
}
