package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.Declaration;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.Declaration;
import java.util.List;


@Repository
public interface DeclarationDao extends AbstractRepository<Declaration,Long>  {
    Declaration findByReference(String reference);
    int deleteByReference(String reference);

    List<Declaration> findByTypeDeclarationId(Long id);
    int deleteByTypeDeclarationId(Long id);

    @Query("SELECT NEW Declaration(item.id,item.libelle) FROM Declaration item")
    List<Declaration> findAllOptimized();
}
