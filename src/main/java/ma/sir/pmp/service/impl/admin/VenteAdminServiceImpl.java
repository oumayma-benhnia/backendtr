package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.bean.history.VenteHistory;
import ma.sir.pmp.dao.criteria.core.VenteCriteria;
import ma.sir.pmp.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.pmp.dao.facade.core.VenteDao;
import ma.sir.pmp.dao.facade.history.VenteHistoryDao;
import ma.sir.pmp.dao.specification.core.VenteSpecification;
import ma.sir.pmp.service.facade.admin.ClientAdminService;
import ma.sir.pmp.service.facade.admin.VenteAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteAdminServiceImpl extends AbstractServiceImpl<Vente, VenteHistory, VenteCriteria, VenteHistoryCriteria, VenteDao,
        VenteHistoryDao> implements VenteAdminService {

    public Vente findByCodeEntity(Vente t) {
        return dao.findByCode(t.getCode());
    }
    public void configure() {
        super.configure(Vente.class, VenteHistory.class, VenteHistoryCriteria.class, VenteSpecification.class);
    }
    public VenteAdminServiceImpl(VenteDao dao, VenteHistoryDao historyDao) {
        super(dao, historyDao);
    }
    public Vente findByClientId(Long id) {
        return dao.findByClientId(id);
    }
    @Autowired
     private ClientAdminService clientService;
}