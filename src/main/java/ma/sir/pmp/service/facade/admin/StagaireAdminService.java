package ma.sir.pmp.service.facade.admin;

import ma.sir.pmp.bean.core.Stagaire;
import ma.sir.pmp.dao.criteria.core.StagaireCriteria;
import ma.sir.pmp.dao.criteria.history.StagaireHistoryCriteria;
import ma.sir.pmp.zynerator.service.IService;

public interface StagaireAdminService extends IService<Stagaire, StagaireCriteria, StagaireHistoryCriteria> {
    Stagaire findByNomAndPrenom(String nom, String prenom);
    int deleteByNomAndPrenom(String nom, String prenom);

}
