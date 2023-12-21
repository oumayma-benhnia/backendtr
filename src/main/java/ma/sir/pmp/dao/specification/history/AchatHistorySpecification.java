package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.AchatHistory;
import ma.sir.pmp.dao.criteria.history.AchatHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class AchatHistorySpecification extends AbstractHistorySpecification<AchatHistoryCriteria, AchatHistory> {
    public AchatHistorySpecification(AchatHistoryCriteria criteria) {
        super(criteria);
    }

    public AchatHistorySpecification(AchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
