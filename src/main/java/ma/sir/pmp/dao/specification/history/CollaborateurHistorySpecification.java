package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.CollaborateurHistoryCriteria;
import ma.sir.pmp.bean.history.CollaborateurHistory;


public class CollaborateurHistorySpecification extends AbstractHistorySpecification<CollaborateurHistoryCriteria, CollaborateurHistory> {

    public CollaborateurHistorySpecification(CollaborateurHistoryCriteria criteria) {
        super(criteria);
    }

    public CollaborateurHistorySpecification(CollaborateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
