package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.dao.criteria.core.FournisseurCriteria;
import ma.sir.pmp.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria, FournisseurHistoryCriteria>  {




}
