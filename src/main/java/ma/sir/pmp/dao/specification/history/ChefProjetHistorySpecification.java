package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.ChefProjetHistoryCriteria;
import ma.sir.pmp.bean.history.ChefProjetHistory;


public class ChefProjetHistorySpecification extends AbstractHistorySpecification<ChefProjetHistoryCriteria, ChefProjetHistory> {

    public ChefProjetHistorySpecification(ChefProjetHistoryCriteria criteria) {
        super(criteria);
    }

    public ChefProjetHistorySpecification(ChefProjetHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
