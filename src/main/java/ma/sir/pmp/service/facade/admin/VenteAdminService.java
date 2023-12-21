package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.core.VenteCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface VenteAdminService extends IService<Vente, VenteCriteria , VenteHistoryCriteria> {
    Vente findByClientId(Long id);
}
