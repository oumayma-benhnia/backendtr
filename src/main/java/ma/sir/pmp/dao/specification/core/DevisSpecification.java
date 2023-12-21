package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.DevisCriteria;
import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.core.Projet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DevisSpecification extends AbstractSpecification<DevisCriteria, Devis> {

    @Override
    public void constructPredicates() {
        addPredicate("reference", criteria.getReference(), criteria.getReferencelike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibellelike());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicate("dateEcheance", criteria.getDateEcheance(), criteria.getDateEcheanceFrom(), criteria.getDateEcheanceTo());
        addPredicateFk("client", "id", criteria.getClient() == null ? null : criteria.getClient().getId());
        addPredicateFk("client", "id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
        addPredicateFk("projet", "id", criteria.getProjet() == null ? null : criteria.getProjet().getId());
        addPredicateFk("projet", "id", criteria.getProjets());
        addPredicateFk("projet","code", criteria.getProjet()==null?null:criteria.getProjet().getCode());
    }

    public DevisSpecification(DevisCriteria criteria) {
        super(criteria);
    }

    public DevisSpecification(DevisCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}

