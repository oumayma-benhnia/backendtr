package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.BonDeCommande;
import ma.sir.pmp.dao.criteria.core.BonDeCommandeCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

import java.util.List;

public interface BonDeCommandeAdminService extends IService<BonDeCommande, BonDeCommandeCriteria, BonDeCommandeHistoryCriteria> {
    List<BonDeCommande> findByClientId(Long id);
}
