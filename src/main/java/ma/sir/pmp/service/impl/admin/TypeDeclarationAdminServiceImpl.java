package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.TypeDeclaration;
import ma.sir.pmp.bean.history.TypeDeclarationHistory;
import ma.sir.pmp.dao.criteria.core.TypeDeclarationCriteria;
import ma.sir.pmp.dao.criteria.history.TypeDeclarationHistoryCriteria;
import ma.sir.pmp.dao.facade.core.TypeDeclarationDao;
import ma.sir.pmp.dao.facade.history.TypeDeclarationHistoryDao;
import ma.sir.pmp.dao.specification.core.TypeDeclarationSpecification;
import ma.sir.pmp.service.facade.admin.TypeDeclarationAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class TypeDeclarationAdminServiceImpl extends AbstractServiceImpl<TypeDeclaration,TypeDeclarationHistory, TypeDeclarationCriteria, TypeDeclarationHistoryCriteria, TypeDeclarationDao,
TypeDeclarationHistoryDao> implements TypeDeclarationAdminService {


    public TypeDeclaration findByReferenceEntity(TypeDeclaration t){
        return  dao.findByReference(t.getReference());
    }




    public void configure() {
        super.configure(TypeDeclaration.class,TypeDeclarationHistory.class, TypeDeclarationHistoryCriteria.class, TypeDeclarationSpecification.class);
    }


    public TypeDeclarationAdminServiceImpl(TypeDeclarationDao dao, TypeDeclarationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}