package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.TypeProjetHistoryCriteria;
import ma.sir.pmp.bean.history.TypeProjetHistory;


public class TypeProjetHistorySpecification extends AbstractHistorySpecification<TypeProjetHistoryCriteria, TypeProjetHistory> {

    public TypeProjetHistorySpecification(TypeProjetHistoryCriteria criteria) {
        super(criteria);
    }

    public TypeProjetHistorySpecification(TypeProjetHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
