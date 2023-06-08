package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.history.ClientHistory;
import ma.sir.pmp.dao.criteria.core.ClientCriteria;
import ma.sir.pmp.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.pmp.dao.facade.core.ClientDao;
import ma.sir.pmp.dao.facade.history.ClientHistoryDao;
import ma.sir.pmp.dao.specification.core.ClientSpecification;
import ma.sir.pmp.service.facade.admin.ClientAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {


    public Client findByReferenceEntity(Client t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }


    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}