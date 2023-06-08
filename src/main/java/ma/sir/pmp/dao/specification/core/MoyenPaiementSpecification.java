package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.MoyenPaiementCriteria;
import ma.sir.pmp.bean.core.MoyenPaiement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MoyenPaiementSpecification extends  AbstractSpecification<MoyenPaiementCriteria, MoyenPaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("dateRemarque", criteria.getDateRemarque(), criteria.getDateRemarqueFrom(), criteria.getDateRemarqueTo());
    }

    public MoyenPaiementSpecification(MoyenPaiementCriteria criteria) {
        super(criteria);
    }

    public MoyenPaiementSpecification(MoyenPaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
