package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Achat;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.bean.history.AchatHistory;
import ma.sir.pmp.dao.criteria.core.AchatCriteria;
import ma.sir.pmp.dao.criteria.history.AchatHistoryCriteria;
import ma.sir.pmp.dao.facade.core.AchatDao;
import ma.sir.pmp.dao.facade.history.AchatHistoryDao;
import ma.sir.pmp.dao.specification.core.AchatSpecification;
import ma.sir.pmp.service.facade.admin.AchatAdminService;
import ma.sir.pmp.service.facade.admin.FournisseurAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AchatAdminServiceImpl extends AbstractServiceImpl<Achat, AchatHistory, AchatCriteria, AchatHistoryCriteria, AchatDao,
        AchatHistoryDao> implements AchatAdminService {

    @Autowired
    private FournisseurAdminService fournisseurService;

    public Achat findByCodeEntity(Achat t) {
        return dao.findByCode(t.getCode());
    }


    public Achat findByDateAchat(LocalDateTime dateAchat) {
        return dao.findByDateAchat(dateAchat);
    }

    public List<Achat> findByFournisseurId(Long id) {
        return dao.findByFournisseurId(id);
    }



    public void configure() {
        super.configure(Achat.class, AchatHistory.class, AchatHistoryCriteria.class, AchatSpecification.class);
    }



    public AchatAdminServiceImpl(AchatDao dao, AchatHistoryDao historyDao) {
        super(dao, historyDao);
    }
}