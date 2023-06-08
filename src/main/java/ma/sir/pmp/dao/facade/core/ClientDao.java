package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Client;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Client;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {
    Client findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Client(item.id,item.code) FROM Client item")
    List<Client> findAllOptimized();
}
