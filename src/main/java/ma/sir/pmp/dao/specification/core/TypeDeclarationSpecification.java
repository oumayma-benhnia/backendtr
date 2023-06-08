package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.TypeDeclarationCriteria;
import ma.sir.pmp.bean.core.TypeDeclaration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TypeDeclarationSpecification extends  AbstractSpecification<TypeDeclarationCriteria, TypeDeclaration>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeDeclarationSpecification(TypeDeclarationCriteria criteria) {
        super(criteria);
    }

    public TypeDeclarationSpecification(TypeDeclarationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
