package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.DeclarationHistoryCriteria;
import ma.sir.pmp.bean.history.DeclarationHistory;


public class DeclarationHistorySpecification extends AbstractHistorySpecification<DeclarationHistoryCriteria, DeclarationHistory> {

    public DeclarationHistorySpecification(DeclarationHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationHistorySpecification(DeclarationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
