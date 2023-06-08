package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Remarque;
import ma.sir.pmp.dao.criteria.core.RemarqueCriteria;
import ma.sir.pmp.dao.criteria.history.RemarqueHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface RemarqueAdminService extends  IService<Remarque,RemarqueCriteria, RemarqueHistoryCriteria>  {

    List<Remarque> findByProjetId(Long id);
    int deleteByProjetId(Long id);



}
