package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Remarque;
import ma.sir.pmp.bean.history.RemarqueHistory;
import ma.sir.pmp.dao.criteria.core.RemarqueCriteria;
import ma.sir.pmp.dao.criteria.history.RemarqueHistoryCriteria;
import ma.sir.pmp.dao.facade.core.RemarqueDao;
import ma.sir.pmp.dao.facade.history.RemarqueHistoryDao;
import ma.sir.pmp.dao.specification.core.RemarqueSpecification;
import ma.sir.pmp.service.facade.admin.RemarqueAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.ProjetAdminService ;


import java.util.List;
@Service
public class RemarqueAdminServiceImpl extends AbstractServiceImpl<Remarque,RemarqueHistory, RemarqueCriteria, RemarqueHistoryCriteria, RemarqueDao,
RemarqueHistoryDao> implements RemarqueAdminService {


    public Remarque findByReferenceEntity(Remarque t){
        return  dao.findByCode(t.getCode());
    }

    public List<Remarque> findByProjetId(Long id){
        return dao.findByProjetId(id);
    }
    public int deleteByProjetId(Long id){
        return dao.deleteByProjetId(id);
    }



    public void configure() {
        super.configure(Remarque.class,RemarqueHistory.class, RemarqueHistoryCriteria.class, RemarqueSpecification.class);
    }

    @Autowired
    private ProjetAdminService projetService ;

    public RemarqueAdminServiceImpl(RemarqueDao dao, RemarqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}