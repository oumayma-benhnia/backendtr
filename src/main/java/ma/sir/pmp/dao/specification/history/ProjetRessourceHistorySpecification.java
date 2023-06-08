package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.ProjetRessourceHistoryCriteria;
import ma.sir.pmp.bean.history.ProjetRessourceHistory;


public class ProjetRessourceHistorySpecification extends AbstractHistorySpecification<ProjetRessourceHistoryCriteria, ProjetRessourceHistory> {

    public ProjetRessourceHistorySpecification(ProjetRessourceHistoryCriteria criteria) {
        super(criteria);
    }

    public ProjetRessourceHistorySpecification(ProjetRessourceHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
