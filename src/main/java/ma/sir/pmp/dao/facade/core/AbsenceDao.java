package ma.sir.pmp.dao.facade.core;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.core.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import ma.sir.pmp.zynerator.repository.AbstractRepository;

public interface AbsenceDao extends AbstractRepository<Absence,Long> {
    Absence findByCode(String code);
    Absence findByDateAbsence (LocalDateTime dateAbsence);

    int deleteByCode(String code);
    // Custom query to search by employees' names, chefProjets' names, and stagiaires' names
    @Query("SELECT DISTINCT a FROM Absence a " +
            "LEFT JOIN a.employes e " +
            "LEFT JOIN a.chefProjets c " +
            "LEFT JOIN a.stagaires s " +
            "WHERE LOWER(e.nom) LIKE LOWER(CONCAT('%', :employeeName, '%')) " +
            "OR LOWER(c.nom) LIKE LOWER(CONCAT('%', :chefProjetName, '%')) " +
            "OR LOWER(s.nom) LIKE LOWER(CONCAT('%', :stagiaireName, '%'))")
    List<Absence> findByNames(
            @Param("employeeName") String employeeName,
            @Param("chefProjetName") String chefProjetName,
            @Param("stagiaireName") String stagiaireName
    );

    @Query("SELECT NEW Absence (item.id,item.code) FROM Absence item")
    List<Absence> findAllOptimized();



}
