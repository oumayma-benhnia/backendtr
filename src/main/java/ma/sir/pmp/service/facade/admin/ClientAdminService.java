package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.dao.criteria.core.ClientCriteria;
import ma.sir.pmp.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {




}
