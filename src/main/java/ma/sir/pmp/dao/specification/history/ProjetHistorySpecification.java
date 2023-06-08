package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.ProjetHistoryCriteria;
import ma.sir.pmp.bean.history.ProjetHistory;


public class ProjetHistorySpecification extends AbstractHistorySpecification<ProjetHistoryCriteria, ProjetHistory> {

    public ProjetHistorySpecification(ProjetHistoryCriteria criteria) {
        super(criteria);
    }

    public ProjetHistorySpecification(ProjetHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
