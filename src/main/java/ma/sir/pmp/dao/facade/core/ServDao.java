package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServDao extends AbstractRepository<Serv, Long> {
    Serv findByCode(String code);

    int deleteByCode(String code);

    @Query("SELECT NEW Serv(item.id, item.libelle) FROM Serv item")
    List<Serv> findAllOptimized();
}