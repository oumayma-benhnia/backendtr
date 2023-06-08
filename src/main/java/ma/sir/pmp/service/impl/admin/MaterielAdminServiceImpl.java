package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.bean.history.MaterielHistory;
import ma.sir.pmp.dao.criteria.core.MaterielCriteria;
import ma.sir.pmp.dao.criteria.history.MaterielHistoryCriteria;
import ma.sir.pmp.dao.facade.core.MaterielDao;
import ma.sir.pmp.dao.facade.history.MaterielHistoryDao;
import ma.sir.pmp.dao.specification.core.MaterielSpecification;
import ma.sir.pmp.service.facade.admin.MaterielAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import ma.sir.pmp.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.pmp.service.facade.admin.CategorieMaterielAdminService ;


import java.util.List;
@Service
public class MaterielAdminServiceImpl extends AbstractServiceImpl<Materiel,MaterielHistory, MaterielCriteria, MaterielHistoryCriteria, MaterielDao,
MaterielHistoryDao> implements MaterielAdminService {


    public Materiel findByReferenceEntity(Materiel t){
        return  dao.findByReference(t.getReference());
    }

    public List<Materiel> findByCategorieMaterielId(Long id){
        return dao.findByCategorieMaterielId(id);
    }
    public int deleteByCategorieMaterielId(Long id){
        return dao.deleteByCategorieMaterielId(id);
    }



    public void configure() {
        super.configure(Materiel.class,MaterielHistory.class, MaterielHistoryCriteria.class, MaterielSpecification.class);
    }

    @Autowired
    private CategorieMaterielAdminService categorieMaterielService ;

    public MaterielAdminServiceImpl(MaterielDao dao, MaterielHistoryDao historyDao) {
        super(dao, historyDao);
    }

}