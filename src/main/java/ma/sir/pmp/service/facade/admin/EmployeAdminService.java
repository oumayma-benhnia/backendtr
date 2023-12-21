package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.core.EmployeCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.EmployeHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface EmployeAdminService extends IService<Employe, EmployeCriteria, EmployeHistoryCriteria> {
    Employe findByNomAndPrenom(String nom,String prenom);

    int deleteByNomAndPrenom(String nom,String prenom);
}
