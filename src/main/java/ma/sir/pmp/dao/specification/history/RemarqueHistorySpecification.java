package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.RemarqueHistoryCriteria;
import ma.sir.pmp.bean.history.RemarqueHistory;


public class RemarqueHistorySpecification extends AbstractHistorySpecification<RemarqueHistoryCriteria, RemarqueHistory> {

    public RemarqueHistorySpecification(RemarqueHistoryCriteria criteria) {
        super(criteria);
    }

    public RemarqueHistorySpecification(RemarqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
