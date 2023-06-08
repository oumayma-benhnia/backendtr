package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.PaiementHistoryCriteria;
import ma.sir.pmp.bean.history.PaiementHistory;


public class PaiementHistorySpecification extends AbstractHistorySpecification<PaiementHistoryCriteria, PaiementHistory> {

    public PaiementHistorySpecification(PaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementHistorySpecification(PaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
