package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.bean.history.CategorieMaterielHistory;


public class CategorieMaterielHistorySpecification extends AbstractHistorySpecification<CategorieMaterielHistoryCriteria, CategorieMaterielHistory> {

    public CategorieMaterielHistorySpecification(CategorieMaterielHistoryCriteria criteria) {
        super(criteria);
    }

    public CategorieMaterielHistorySpecification(CategorieMaterielHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
