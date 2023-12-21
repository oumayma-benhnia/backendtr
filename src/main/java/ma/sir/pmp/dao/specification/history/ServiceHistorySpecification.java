package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.ServiceHistory;
import ma.sir.pmp.dao.criteria.history.ServiceHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class ServiceHistorySpecification extends AbstractHistorySpecification<ServiceHistoryCriteria, ServiceHistory> {
    public ServiceHistorySpecification(ServiceHistoryCriteria criteria) {
        super(criteria);
    }

    public ServiceHistorySpecification(ServiceHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
