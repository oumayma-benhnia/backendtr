package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Paiement;
import ma.sir.pmp.dao.criteria.core.PaiementCriteria;
import ma.sir.pmp.dao.criteria.history.PaiementHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface PaiementAdminService extends  IService<Paiement,PaiementCriteria, PaiementHistoryCriteria>  {

    List<Paiement> findByFactureId(Long id);
    int deleteByFactureId(Long id);
    List<Paiement> findByMoyenPaiementId(Long id);
    int deleteByMoyenPaiementId(Long id);



}
