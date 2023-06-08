package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Declaration;
import ma.sir.pmp.bean.history.DeclarationHistory;
import ma.sir.pmp.dao.criteria.core.DeclarationCriteria;
import ma.sir.pmp.dao.criteria.history.DeclarationHistoryCriteria;
import ma.sir.pmp.dao.facade.core.DeclarationDao;
import ma.sir.pmp.dao.facade.history.DeclarationHistoryDao;
import ma.sir.pmp.dao.specification.core.DeclarationSpecification;
import ma.sir.pmp.service.facade.admin.DeclarationAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.TypeDeclarationAdminService ;


import java.util.List;
@Service
public class DeclarationAdminServiceImpl extends AbstractServiceImpl<Declaration,DeclarationHistory, DeclarationCriteria, DeclarationHistoryCriteria, DeclarationDao,
DeclarationHistoryDao> implements DeclarationAdminService {


    public Declaration findByReferenceEntity(Declaration t){
        return  dao.findByReference(t.getReference());
    }

    public List<Declaration> findByTypeDeclarationId(Long id){
        return dao.findByTypeDeclarationId(id);
    }
    public int deleteByTypeDeclarationId(Long id){
        return dao.deleteByTypeDeclarationId(id);
    }



    public void configure() {
        super.configure(Declaration.class,DeclarationHistory.class, DeclarationHistoryCriteria.class, DeclarationSpecification.class);
    }

    @Autowired
    private TypeDeclarationAdminService typeDeclarationService ;

    public DeclarationAdminServiceImpl(DeclarationDao dao, DeclarationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}