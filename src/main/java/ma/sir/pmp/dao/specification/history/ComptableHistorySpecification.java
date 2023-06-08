package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.ComptableHistoryCriteria;
import ma.sir.pmp.bean.history.ComptableHistory;


public class ComptableHistorySpecification extends AbstractHistorySpecification<ComptableHistoryCriteria, ComptableHistory> {

    public ComptableHistorySpecification(ComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public ComptableHistorySpecification(ComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
