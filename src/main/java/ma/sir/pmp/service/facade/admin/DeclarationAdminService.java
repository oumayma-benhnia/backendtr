package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Declaration;
import ma.sir.pmp.dao.criteria.core.DeclarationCriteria;
import ma.sir.pmp.dao.criteria.history.DeclarationHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface DeclarationAdminService extends  IService<Declaration,DeclarationCriteria, DeclarationHistoryCriteria>  {

    List<Declaration> findByTypeDeclarationId(Long id);
    int deleteByTypeDeclarationId(Long id);



}
