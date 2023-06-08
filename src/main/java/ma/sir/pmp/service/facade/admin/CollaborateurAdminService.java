package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Collaborateur;
import ma.sir.pmp.dao.criteria.core.CollaborateurCriteria;
import ma.sir.pmp.dao.criteria.history.CollaborateurHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface CollaborateurAdminService extends  IService<Collaborateur,CollaborateurCriteria, CollaborateurHistoryCriteria>  {




}
