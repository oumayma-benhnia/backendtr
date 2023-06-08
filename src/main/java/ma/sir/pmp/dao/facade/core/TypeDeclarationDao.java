package ma.sir.pmp.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.bean.core.TypeDeclaration;
import org.springframework.stereotype.Repository;
import ma.sir.pmp.bean.core.TypeDeclaration;
import java.util.List;


@Repository
public interface TypeDeclarationDao extends AbstractRepository<TypeDeclaration,Long>  {
    TypeDeclaration findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW TypeDeclaration(item.id,item.libelle) FROM TypeDeclaration item")
    List<TypeDeclaration> findAllOptimized();
}
