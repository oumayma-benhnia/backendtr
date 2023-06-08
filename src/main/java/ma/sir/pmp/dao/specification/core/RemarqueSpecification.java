package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.RemarqueCriteria;
import ma.sir.pmp.bean.core.Remarque;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RemarqueSpecification extends  AbstractSpecification<RemarqueCriteria, Remarque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("dateRemarque", criteria.getDateRemarque(), criteria.getDateRemarqueFrom(), criteria.getDateRemarqueTo());
        addPredicateFk("projet","id", criteria.getProjet()==null?null:criteria.getProjet().getId());
        addPredicateFk("projet","id", criteria.getProjets());
        addPredicateFk("projet","code", criteria.getProjet()==null?null:criteria.getProjet().getCode());
    }

    public RemarqueSpecification(RemarqueCriteria criteria) {
        super(criteria);
    }

    public RemarqueSpecification(RemarqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
