package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.bean.core.Facture;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FactureSpecification extends  AbstractSpecification<FactureCriteria, Facture>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicate("dateEcheance", criteria.getDateEcheance(), criteria.getDateEcheanceFrom(), criteria.getDateEcheanceTo());
        addPredicateFk("comptable","id", criteria.getComptable()==null?null:criteria.getComptable().getId());
        addPredicateFk("comptable","id", criteria.getComptables());
        addPredicateFk("comptable","code", criteria.getComptable()==null?null:criteria.getComptable().getCode());
        addPredicateFk("projet","id", criteria.getProjet()==null?null:criteria.getProjet().getId());
        addPredicateFk("projet","id", criteria.getProjets());
        addPredicateFk("projet","code", criteria.getProjet()==null?null:criteria.getProjet().getCode());
    }

    public FactureSpecification(FactureCriteria criteria) {
        super(criteria);
    }

    public FactureSpecification(FactureCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
