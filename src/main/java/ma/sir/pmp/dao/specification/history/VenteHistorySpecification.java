package ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.bean.history.AbsenceHistory;
import ma.sir.pmp.bean.history.VenteHistory;
import ma.sir.pmp.dao.criteria.history.AbsenceHistoryCriteria;
import ma.sir.pmp.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;


public class VenteHistorySpecification extends AbstractHistorySpecification<VenteHistoryCriteria, VenteHistory> {
    public VenteHistorySpecification(VenteHistoryCriteria criteria) {
        super(criteria);
    }

    public VenteHistorySpecification(VenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
