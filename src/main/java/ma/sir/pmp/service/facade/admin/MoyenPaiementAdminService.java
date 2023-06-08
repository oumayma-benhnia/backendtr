package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.MoyenPaiement;
import ma.sir.pmp.dao.criteria.core.MoyenPaiementCriteria;
import ma.sir.pmp.dao.criteria.history.MoyenPaiementHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface MoyenPaiementAdminService extends  IService<MoyenPaiement,MoyenPaiementCriteria, MoyenPaiementHistoryCriteria>  {




}
