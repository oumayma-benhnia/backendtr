package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.TacheHistoryCriteria;
import ma.sir.pmp.bean.history.TacheHistory;


public class TacheHistorySpecification extends AbstractHistorySpecification<TacheHistoryCriteria, TacheHistory> {

    public TacheHistorySpecification(TacheHistoryCriteria criteria) {
        super(criteria);
    }

    public TacheHistorySpecification(TacheHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
