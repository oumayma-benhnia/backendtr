package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.history.TypeVenteHistory;
import ma.sir.pmp.dao.criteria.history.TypeVenteHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;

public class TypeVenteHistorySpecification extends AbstractHistorySpecification<TypeVenteHistoryCriteria, TypeVenteHistory> {
    public TypeVenteHistorySpecification(TypeVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public TypeVenteHistorySpecification(TypeVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
