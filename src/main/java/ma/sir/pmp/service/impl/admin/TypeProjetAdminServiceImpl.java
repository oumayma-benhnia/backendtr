package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.TypeProjet;
import ma.sir.pmp.bean.history.TypeProjetHistory;
import ma.sir.pmp.dao.criteria.core.TypeProjetCriteria;
import ma.sir.pmp.dao.criteria.history.TypeProjetHistoryCriteria;
import ma.sir.pmp.dao.facade.core.TypeProjetDao;
import ma.sir.pmp.dao.facade.history.TypeProjetHistoryDao;
import ma.sir.pmp.dao.specification.core.TypeProjetSpecification;
import ma.sir.pmp.service.facade.admin.TypeProjetAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class TypeProjetAdminServiceImpl extends AbstractServiceImpl<TypeProjet,TypeProjetHistory, TypeProjetCriteria, TypeProjetHistoryCriteria, TypeProjetDao,
TypeProjetHistoryDao> implements TypeProjetAdminService {


    public TypeProjet findByReferenceEntity(TypeProjet t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(TypeProjet.class,TypeProjetHistory.class, TypeProjetHistoryCriteria.class, TypeProjetSpecification.class);
    }


    public TypeProjetAdminServiceImpl(TypeProjetDao dao, TypeProjetHistoryDao historyDao) {
        super(dao, historyDao);
    }

}