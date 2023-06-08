package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.bean.core.CategorieMateriel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CategorieMaterielSpecification extends  AbstractSpecification<CategorieMaterielCriteria, CategorieMateriel>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public CategorieMaterielSpecification(CategorieMaterielCriteria criteria) {
        super(criteria);
    }

    public CategorieMaterielSpecification(CategorieMaterielCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
