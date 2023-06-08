package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.RessourceHistoryCriteria;
import ma.sir.pmp.bean.history.RessourceHistory;


public class RessourceHistorySpecification extends AbstractHistorySpecification<RessourceHistoryCriteria, RessourceHistory> {

    public RessourceHistorySpecification(RessourceHistoryCriteria criteria) {
        super(criteria);
    }

    public RessourceHistorySpecification(RessourceHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
