package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.ProjetCriteria;
import ma.sir.pmp.bean.core.Projet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjetSpecification extends  AbstractSpecification<ProjetCriteria, Projet>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateBigDecimal("budget", criteria.getBudget(), criteria.getBudgetMin(), criteria.getBudgetMax());
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFinEstime", criteria.getDateFinEstime(), criteria.getDateFinEstimeFrom(), criteria.getDateFinEstimeTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("typeProjet","id", criteria.getTypeProjet()==null?null:criteria.getTypeProjet().getId());
        addPredicateFk("typeProjet","id", criteria.getTypeProjets());
        addPredicateFk("typeProjet","code", criteria.getTypeProjet()==null?null:criteria.getTypeProjet().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
        addPredicateFk("chefProjet","id", criteria.getChefProjet()==null?null:criteria.getChefProjet().getId());
        addPredicateFk("chefProjet","id", criteria.getChefProjets());
        addPredicateFk("chefProjet","code", criteria.getChefProjet()==null?null:criteria.getChefProjet().getCode());
    }

    public ProjetSpecification(ProjetCriteria criteria) {
        super(criteria);
    }

    public ProjetSpecification(ProjetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
