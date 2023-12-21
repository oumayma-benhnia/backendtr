package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.core.DevisCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.DevisHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

import java.util.List;

public interface DevisAdminService extends IService<Devis, DevisCriteria, DevisHistoryCriteria> {
    List<Devis> findByProjetId(Long id);
    int deleteByProjetId(Long id);
}
