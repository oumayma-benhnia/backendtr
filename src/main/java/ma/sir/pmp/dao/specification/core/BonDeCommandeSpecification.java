package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.BonDeCommande;
import ma.sir.pmp.dao.criteria.core.BonDeCommandeCriteria;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;

public class BonDeCommandeSpecification extends AbstractSpecification<BonDeCommandeCriteria, BonDeCommande> {


    @Override
    public void constructPredicates() {
        addPredicate("reference", criteria.getReference(), criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
        addPredicate("description", criteria.getDescription(), criteria.getDescriptionLike());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicate("dateEcheance", criteria.getDateEcheance(), criteria.getDateEcheanceFrom(), criteria.getDateEcheanceTo());
        addPredicateFk("client", "id", criteria.getClient() == null ? null : criteria.getClient().getId());
        addPredicateFk("client", "id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
    }

    public BonDeCommandeSpecification(BonDeCommandeCriteria criteria) {
        super(criteria);
    }

    public BonDeCommandeSpecification(BonDeCommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
