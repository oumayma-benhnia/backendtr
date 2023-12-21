package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.BonDeCommandeHistory;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class BonDeCommandeHistorySpecification extends AbstractHistorySpecification<BonDeCommandeHistoryCriteria, BonDeCommandeHistory> {
    public BonDeCommandeHistorySpecification(BonDeCommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public BonDeCommandeHistorySpecification(BonDeCommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
