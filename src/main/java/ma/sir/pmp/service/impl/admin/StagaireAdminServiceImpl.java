package ma.sir.pmp.service.impl.admin;

import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.core.Stagaire;

import ma.sir.pmp.bean.history.StagaireHistory;

import ma.sir.pmp.dao.criteria.core.StagaireCriteria;

import ma.sir.pmp.dao.criteria.history.StagaireHistoryCriteria;

import ma.sir.pmp.dao.facade.core.StagaireDao;

import ma.sir.pmp.dao.facade.history.StagaireHistoryDao;

import ma.sir.pmp.dao.specification.core.StagaireSpecification;

import ma.sir.pmp.service.facade.admin.StagaireAdminService;
import ma.sir.pmp.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StagaireAdminServiceImpl extends AbstractServiceImpl<Stagaire, StagaireHistory, StagaireCriteria, StagaireHistoryCriteria, StagaireDao,
        StagaireHistoryDao> implements StagaireAdminService {

    public Stagaire findByCodeEntity(Stagaire t) {
        return dao.findByCode(t.getCode());
    }
     public void configure() {
        super.configure(Stagaire.class, StagaireHistory.class, StagaireHistoryCriteria.class, StagaireSpecification.class);
    }

    public StagaireAdminServiceImpl(StagaireDao dao, StagaireHistoryDao historyDao) {
        super(dao, historyDao);
    }

    public int deleteByNomAndPrenom(String nom, String prenom) {
        return dao.deleteByNomAndPrenom(nom, prenom);
    }


    public Stagaire findByNomAndPrenom(String nom, String prenom) {
        return dao.findByNomAndPrenom(nom, prenom);
    }
}