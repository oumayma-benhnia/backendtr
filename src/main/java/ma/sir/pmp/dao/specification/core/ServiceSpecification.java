package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Service;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.ServiceCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ServiceSpecification extends AbstractSpecification<ServiceCriteria, Service> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
    }

    public ServiceSpecification(ServiceCriteria criteria) {
        super(criteria);
    }

    public ServiceSpecification(ServiceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}