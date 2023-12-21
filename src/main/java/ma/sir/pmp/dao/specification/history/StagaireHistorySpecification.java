package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.StagaireHistory;
import ma.sir.pmp.dao.criteria.history.StagaireHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class StagaireHistorySpecification extends AbstractHistorySpecification<StagaireHistoryCriteria, StagaireHistory> {
    public StagaireHistorySpecification(StagaireHistoryCriteria criteria) {
        super(criteria);
    }

    public StagaireHistorySpecification(StagaireHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
