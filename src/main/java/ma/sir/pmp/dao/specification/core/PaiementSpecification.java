package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.PaiementCriteria;
import ma.sir.pmp.bean.core.Paiement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementSpecification extends  AbstractSpecification<PaiementCriteria, Paiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("facture","id", criteria.getFacture()==null?null:criteria.getFacture().getId());
        addPredicateFk("facture","id", criteria.getFactures());
        addPredicateFk("facture","reference", criteria.getFacture()==null?null:criteria.getFacture().getReference());
        addPredicateFk("moyenPaiement","id", criteria.getMoyenPaiement()==null?null:criteria.getMoyenPaiement().getId());
        addPredicateFk("moyenPaiement","id", criteria.getMoyenPaiements());
        addPredicateFk("moyenPaiement","code", criteria.getMoyenPaiement()==null?null:criteria.getMoyenPaiement().getCode());
    }

    public PaiementSpecification(PaiementCriteria criteria) {
        super(criteria);
    }

    public PaiementSpecification(PaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
