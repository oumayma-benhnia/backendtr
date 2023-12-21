package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.EmployeCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeSpecification extends AbstractSpecification<EmployeCriteria, Employe> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(), criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(), criteria.getPrenomLike());
        addPredicate("email", criteria.getEmail(), criteria.getEmailLike());
        addPredicate("tele", criteria.getTele(), criteria.getTeleLike());
        addPredicate("fonction", criteria.getFonctionLike());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
    }

    public EmployeSpecification(EmployeCriteria criteria) {
        super(criteria);
    }

    public EmployeSpecification(EmployeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
