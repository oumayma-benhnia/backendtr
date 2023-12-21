package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.AbsenceHistory;
import ma.sir.pmp.dao.criteria.history.AbsenceHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class AbsenceHistorySpecification extends AbstractHistorySpecification<AbsenceHistoryCriteria, AbsenceHistory> {
    public AbsenceHistorySpecification(AbsenceHistoryCriteria criteria) {
        super(criteria);
    }

    public AbsenceHistorySpecification(AbsenceHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
