package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.ServHistory;
import ma.sir.pmp.dao.criteria.history.ServHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class ServHistorySpecification extends AbstractHistorySpecification<ServHistoryCriteria, ServHistory> {
    public ServHistorySpecification(ServHistoryCriteria criteria) {
        super(criteria);
    }

    public ServHistorySpecification(ServHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}