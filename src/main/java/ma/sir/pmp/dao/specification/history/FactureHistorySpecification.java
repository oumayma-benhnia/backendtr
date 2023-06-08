package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.bean.history.FactureHistory;


public class FactureHistorySpecification extends AbstractHistorySpecification<FactureHistoryCriteria, FactureHistory> {

    public FactureHistorySpecification(FactureHistoryCriteria criteria) {
        super(criteria);
    }

    public FactureHistorySpecification(FactureHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
