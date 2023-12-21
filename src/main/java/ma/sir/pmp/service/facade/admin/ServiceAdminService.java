package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.core.Service;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.core.ServiceCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.ServiceHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface ServiceAdminService extends IService<Service, ServiceCriteria, ServiceHistoryCriteria> {
}
