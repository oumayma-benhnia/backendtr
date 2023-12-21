package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.dao.criteria.core.BonDeLivraisonCriteria;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeLivraisonHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

import java.time.LocalDateTime;
import java.util.List;

public interface BonDeLivraisonAdminService extends IService<BonDeLivraison, BonDeLivraisonCriteria, BonDeLivraisonHistoryCriteria> {
    List<BonDeLivraison> findByClientId(Long id);
    List<BonDeLivraison> findByFournisseurId(Long id);

    BonDeLivraison findByDateLivraison(LocalDateTime dateLivraison);
}
