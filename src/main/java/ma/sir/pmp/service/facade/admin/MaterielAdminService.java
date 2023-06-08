package ma.sir.pmp.service.facade.admin;

import java.util.List;
import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.dao.criteria.core.MaterielCriteria;
import ma.sir.pmp.dao.criteria.history.MaterielHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;


public interface MaterielAdminService extends  IService<Materiel,MaterielCriteria, MaterielHistoryCriteria>  {

    List<Materiel> findByCategorieMaterielId(Long id);
    int deleteByCategorieMaterielId(Long id);



}
