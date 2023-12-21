package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Stagaire;
import ma.sir.pmp.bean.core.TypeProjet;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StagaireDao extends AbstractRepository<Stagaire,Long> {
    Stagaire findByCode(String code);
    int deleteByCode(String code);
    Stagaire findByNomAndPrenom(String nom, String prenom);
    int deleteByNomAndPrenom(String nom, String prenom);



    @Query("SELECT NEW Stagaire (item.id,item.code) FROM Stagaire item")
    List<Stagaire> findAllOptimized();
}



