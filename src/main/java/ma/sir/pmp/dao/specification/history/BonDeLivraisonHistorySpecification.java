package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.BonDeLivraisonHistory;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class BonDeLivraisonHistorySpecification extends AbstractHistorySpecification<BonDeCommandeHistoryCriteria, BonDeLivraisonHistory> {
    public BonDeLivraisonHistorySpecification(BonDeCommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public BonDeLivraisonHistorySpecification(BonDeCommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
