package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Achat;
import ma.sir.pmp.bean.core.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AchatDao extends AbstractRepository<Achat,Long> {
    Achat findByCode(String code);
    int deleteByCode(String code);
    Achat findByDateAchat(LocalDateTime dateAchat);
    List<Achat> findByFournisseurId(Long id);
    @Query("SELECT NEW Projet(item.id,item.code) FROM Achat item")
    List<Achat> findAllOptimized();
}

