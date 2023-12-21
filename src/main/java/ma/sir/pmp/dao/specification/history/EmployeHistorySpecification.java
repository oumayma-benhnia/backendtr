package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.EmployeHistory;
import ma.sir.pmp.dao.criteria.history.EmployeHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class EmployeHistorySpecification extends AbstractHistorySpecification<EmployeHistoryCriteria, EmployeHistory> {
    public EmployeHistorySpecification(EmployeHistoryCriteria criteria) {
        super(criteria);
    }

    public EmployeHistorySpecification(EmployeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
