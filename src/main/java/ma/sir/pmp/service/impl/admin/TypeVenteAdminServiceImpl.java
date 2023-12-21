package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.bean.history.TypeVenteHistory;
import ma.sir.pmp.dao.criteria.core.TypeVenteCriteria;
import ma.sir.pmp.dao.criteria.history.TypeVenteHistoryCriteria;
import ma.sir.pmp.dao.facade.core.TypeVenteDao;
import ma.sir.pmp.dao.facade.history.TypeVenteHistoryDao;
import ma.sir.pmp.dao.specification.core.TypeVenteSpecification;
import ma.sir.pmp.service.facade.admin.TypeVenteAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeVenteAdminServiceImpl extends AbstractServiceImpl<TypeVente, TypeVenteHistory, TypeVenteCriteria, TypeVenteHistoryCriteria, TypeVenteDao,
        TypeVenteHistoryDao> implements TypeVenteAdminService {

    public TypeVente findByCodeEntity(TypeVente t) {
        return dao.findByCode(t.getCode());
    }

    public void configure() {
        super.configure(TypeVente.class, TypeVenteHistory.class, TypeVenteHistoryCriteria.class, TypeVenteSpecification.class);
    }

    public TypeVenteAdminServiceImpl(TypeVenteDao dao, TypeVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

    @Override
    public TypeVente findByLibelle(String libelle) {
        return dao.findByLibelle( libelle);
    }
}