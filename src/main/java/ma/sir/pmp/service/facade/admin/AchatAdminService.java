package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.Achat;
import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.dao.criteria.core.AchatCriteria;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.history.AchatHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

import java.time.LocalDateTime;
import java.util.List;

public interface AchatAdminService extends IService<Achat, AchatCriteria, AchatHistoryCriteria> {
    Achat findByDateAchat(LocalDateTime dateAchat);
    List<Achat> findByFournisseurId(Long id);
}
