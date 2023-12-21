package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Vente;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.VenteCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class VenteSpecification extends AbstractSpecification<VenteCriteria, Vente> {

    @Override
    public void constructPredicates() {
        addPredicate("code", criteria.getCode(), criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
        addPredicate("dateVente", criteria.getDateVente(), criteria.getDateVenteFrom(), criteria.getDateVenteTo());
        addPredicateFk("typeVente","id", criteria.getTypeVente()==null?null:criteria.getTypeVente().getId());
        addPredicateFk("typeVente","id", criteria.getTypeVentes());
        addPredicateFk("typeVente","code", criteria.getTypeVente()==null?null:criteria.getTypeVente().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
    }

    public VenteSpecification(VenteCriteria criteria) {
        super(criteria);
    }

    public VenteSpecification(VenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
