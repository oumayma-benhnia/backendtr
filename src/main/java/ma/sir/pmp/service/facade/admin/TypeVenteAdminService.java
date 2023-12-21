package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.core.TypeVenteCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.TypeVenteHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface TypeVenteAdminService extends IService<TypeVente, TypeVenteCriteria, TypeVenteHistoryCriteria> {
    TypeVente findByLibelle(String libelle);
}
