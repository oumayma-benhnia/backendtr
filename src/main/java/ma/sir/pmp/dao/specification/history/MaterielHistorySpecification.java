package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.MaterielHistoryCriteria;
import ma.sir.pmp.bean.history.MaterielHistory;


public class MaterielHistorySpecification extends AbstractHistorySpecification<MaterielHistoryCriteria, MaterielHistory> {

    public MaterielHistorySpecification(MaterielHistoryCriteria criteria) {
        super(criteria);
    }

    public MaterielHistorySpecification(MaterielHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
