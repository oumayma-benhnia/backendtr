package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.DevisHistory;
import ma.sir.pmp.dao.criteria.history.DevisHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class DevisHistorySpecification extends AbstractHistorySpecification<DevisHistoryCriteria, DevisHistory> {
    public DevisHistorySpecification(DevisHistoryCriteria criteria) {
        super(criteria);
    }

    public DevisHistorySpecification(DevisHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
