package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.pmp.bean.history.FournisseurHistory;


public class FournisseurHistorySpecification extends AbstractHistorySpecification<FournisseurHistoryCriteria, FournisseurHistory> {

    public FournisseurHistorySpecification(FournisseurHistoryCriteria criteria) {
        super(criteria);
    }

    public FournisseurHistorySpecification(FournisseurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
