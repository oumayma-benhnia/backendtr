package ma.sir.pmp.service.facade.admin;
import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.dao.criteria.core.ServCriteria;
import ma.sir.pmp.dao.criteria.history.ServHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface ServAdminService extends IService <Serv, ServCriteria, ServHistoryCriteria> {
        }
