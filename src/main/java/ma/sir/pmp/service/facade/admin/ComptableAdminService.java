package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Comptable;
import ma.sir.pmp.dao.criteria.core.ComptableCriteria;
import ma.sir.pmp.dao.criteria.history.ComptableHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface ComptableAdminService extends  IService<Comptable,ComptableCriteria, ComptableHistoryCriteria>  {




}
