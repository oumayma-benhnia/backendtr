package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Stagaire;

import ma.sir.pmp.dao.criteria.core.StagaireCriteria;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StagaireSpecification extends AbstractSpecification<StagaireCriteria, Stagaire> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(), criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(), criteria.getPrenomLike());
        addPredicate("email", criteria.getEmail(), criteria.getEmailLike());
        addPredicate("tele", criteria.getTele(), criteria.getTeleLike());
        addPredicate("fonction", criteria.getFonction(), criteria.getFonctionLike());
    }

    public StagaireSpecification(StagaireCriteria criteria) {
        super(criteria);
    }

    public StagaireSpecification(StagaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
