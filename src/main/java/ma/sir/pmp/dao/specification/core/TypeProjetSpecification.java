package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.TypeProjetCriteria;
import ma.sir.pmp.bean.core.TypeProjet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TypeProjetSpecification extends  AbstractSpecification<TypeProjetCriteria, TypeProjet>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeProjetSpecification(TypeProjetCriteria criteria) {
        super(criteria);
    }

    public TypeProjetSpecification(TypeProjetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
