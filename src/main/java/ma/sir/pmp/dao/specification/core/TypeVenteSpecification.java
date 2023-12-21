package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.TypeVenteCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TypeVenteSpecification extends AbstractSpecification<TypeVenteCriteria, TypeVente> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
    }

    public TypeVenteSpecification(TypeVenteCriteria criteria) {
        super(criteria);
    }

    public TypeVenteSpecification(TypeVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}


