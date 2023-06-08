package ma.sir.pmp.zynerator.specification;

import ma.sir.pmp.zynerator.history.HistBusinessObject;
import ma.sir.pmp.zynerator.history.HistCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHistorySpecification<Criteria extends HistCriteria, H extends HistBusinessObject> extends SpecificationHelper<Criteria, H> implements Specification<H> {

    public AbstractHistorySpecification(Criteria criteria) {
        this.criteria = criteria;
    }

    public AbstractHistorySpecification(Criteria criteria, boolean distinct) {
        this.criteria = criteria;
        this.distinct = distinct;
    }

    public Predicate toPredicate(Root<H> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> myPredicates = new ArrayList<>();
        attachSearchElement(root, query, builder, myPredicates);
        if (criteria != null) {
            addPredicateId("id", criteria);
            addPredicate("objectName", criteria.getObjectName(), criteria.getObjectNameLike());
            addPredicate("data", criteria.getData(), criteria.getDataLike());
            addPredicate("username", criteria.getUsername(), criteria.getUsernameLike());
            addPredicateLong("userId", criteria.getUserId());
            addPredicate("actionType", criteria.getActionTypeLike(), criteria.getActionTypeLike());
            addPredicateLong("objectId", criteria.getObjectId());
            addPredicate("actionType", criteria.getDate(), criteria.getDateFrom(), criteria.getDateTo());
            addOrderAndFilter();
        }
        return getResult();
    }
}
