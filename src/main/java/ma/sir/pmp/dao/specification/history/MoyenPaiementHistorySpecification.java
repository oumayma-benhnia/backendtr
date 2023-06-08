package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.MoyenPaiementHistoryCriteria;
import ma.sir.pmp.bean.history.MoyenPaiementHistory;


public class MoyenPaiementHistorySpecification extends AbstractHistorySpecification<MoyenPaiementHistoryCriteria, MoyenPaiementHistory> {

    public MoyenPaiementHistorySpecification(MoyenPaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public MoyenPaiementHistorySpecification(MoyenPaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
