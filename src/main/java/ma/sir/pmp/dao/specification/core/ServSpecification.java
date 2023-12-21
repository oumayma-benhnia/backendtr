package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.ServCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ServSpecification extends AbstractSpecification<ServCriteria, Serv> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
    }

    public ServSpecification(ServCriteria criteria) {
        super(criteria);
    }

    public ServSpecification(ServCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}