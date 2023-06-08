package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.pmp.bean.history.EntiteAdministrativeHistory;


public class EntiteAdministrativeHistorySpecification extends AbstractHistorySpecification<EntiteAdministrativeHistoryCriteria, EntiteAdministrativeHistory> {

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
