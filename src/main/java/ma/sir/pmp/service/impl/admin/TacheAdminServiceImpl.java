package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Tache;
import ma.sir.pmp.bean.history.TacheHistory;
import ma.sir.pmp.dao.criteria.core.TacheCriteria;
import ma.sir.pmp.dao.criteria.history.TacheHistoryCriteria;
import ma.sir.pmp.dao.facade.core.TacheDao;
import ma.sir.pmp.dao.facade.history.TacheHistoryDao;
import ma.sir.pmp.dao.specification.core.TacheSpecification;
import ma.sir.pmp.service.facade.admin.TacheAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.CollaborateurAdminService ;


import java.util.List;
@Service
public class TacheAdminServiceImpl extends AbstractServiceImpl<Tache,TacheHistory, TacheCriteria, TacheHistoryCriteria, TacheDao,
TacheHistoryDao> implements TacheAdminService {


    public Tache findByReferenceEntity(Tache t){
        return  dao.findByCode(t.getCode());
    }

    public List<Tache> findByCollaborateurId(Long id){
        return dao.findByCollaborateurId(id);
    }
    public int deleteByCollaborateurId(Long id){
        return dao.deleteByCollaborateurId(id);
    }

    @Override
    public List<Tache> findByProjetId(Long id) {
        return null;
    }

    @Override
    public int deleteByProjetId(Long id) {
        return 0;
    }


    public void configure() {
        super.configure(Tache.class,TacheHistory.class, TacheHistoryCriteria.class, TacheSpecification.class);
    }

    @Autowired
    private CollaborateurAdminService collaborateurService ;

    public TacheAdminServiceImpl(TacheDao dao, TacheHistoryDao historyDao) {
        super(dao, historyDao);
    }

}