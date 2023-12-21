package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Service;
import ma.sir.pmp.bean.core.TypeProjet;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceDao extends AbstractRepository<Service ,Long> {
    Service findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Service (item.id,item.libelle) FROM Service item")
    List<Service>findAllOptimized();
}

