package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.CollaborateurCriteria;
import ma.sir.pmp.bean.core.Collaborateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CollaborateurSpecification extends  AbstractSpecification<CollaborateurCriteria, Collaborateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("tele", criteria.getTele(),criteria.getTeleLike());
        addPredicate("titre", criteria.getTitre(),criteria.getTitreLike());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria) {
        super(criteria);
    }

    public CollaborateurSpecification(CollaborateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
