package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Collaborateur;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Collaborateur;
import java.util.List;


@Repository
public interface CollaborateurDao extends AbstractRepository<Collaborateur,Long>  {
    Collaborateur findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Collaborateur(item.id,item.code) FROM Collaborateur item")
    List<Collaborateur> findAllOptimized();
}
