package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.bean.history.ServHistory;
import ma.sir.pmp.dao.criteria.core.ServCriteria;
import ma.sir.pmp.dao.criteria.history.ServHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ServDao;
import ma.sir.pmp.dao.facade.history.ServHistoryDao;
import ma.sir.pmp.dao.specification.core.ServSpecification;
import ma.sir.pmp.service.facade.admin.ServAdminService;

import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ServAdminServiceImpl extends AbstractServiceImpl<Serv, ServHistory,
        ServCriteria, ServHistoryCriteria, ServDao,
        ServHistoryDao> implements ServAdminService {

    public Serv findByCodeEntity(Serv t) {
        return dao.findByCode(t.getCode());
    }

    public void configure() {
        super.configure(Serv.class, ServHistory.class, ServHistoryCriteria.class, ServSpecification.class);
    }

    public ServAdminServiceImpl(ServDao dao, ServHistoryDao historyDao) {
        super(dao, historyDao);
    }
}