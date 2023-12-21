package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeDao extends AbstractRepository<Employe,Long> {
    Employe findByCode (String code);
    Employe findByNomAndPrenom(String nom,String prenom);
    int deleteByNomAndPrenom(String nom,String prenom);
    int deleteByCode (String code );
    @Query("SELECT NEW Employe(item.id,item.code) FROM Employe item")
    List<Employe> findAllOptimized();
}
