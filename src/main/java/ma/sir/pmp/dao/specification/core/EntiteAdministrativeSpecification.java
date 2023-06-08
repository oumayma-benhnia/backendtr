package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.pmp.bean.core.EntiteAdministrative;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EntiteAdministrativeSpecification extends  AbstractSpecification<EntiteAdministrativeCriteria, EntiteAdministrative>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public EntiteAdministrativeSpecification(EntiteAdministrativeCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeSpecification(EntiteAdministrativeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
