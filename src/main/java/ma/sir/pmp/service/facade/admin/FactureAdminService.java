package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface FactureAdminService extends  IService<Facture,FactureCriteria, FactureHistoryCriteria>  {


    List<Facture> findByProjetId(Long id);
    List<Facture> findByClientId(Long id);

    int deleteByProjetId(Long id);




}
