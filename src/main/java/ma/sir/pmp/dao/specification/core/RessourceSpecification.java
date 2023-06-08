package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.RessourceCriteria;
import ma.sir.pmp.bean.core.Ressource;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RessourceSpecification extends  AbstractSpecification<RessourceCriteria, Ressource>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateBigDecimal("cout", criteria.getCout(), criteria.getCoutMin(), criteria.getCoutMax());
        addPredicate("type", criteria.getType(),criteria.getTypeLike());
        addPredicate("unite", criteria.getUnite(),criteria.getUniteLike());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","code", criteria.getFournisseur()==null?null:criteria.getFournisseur().getCode());
        addPredicateFk("materiel","id", criteria.getMateriel()==null?null:criteria.getMateriel().getId());
        addPredicateFk("materiel","id", criteria.getMateriels());
        addPredicateFk("materiel","reference", criteria.getMateriel()==null?null:criteria.getMateriel().getReference());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","code", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getCode());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getId());
        addPredicateFk("entiteAdministrative","id", criteria.getEntiteAdministratives());
        addPredicateFk("entiteAdministrative","code", criteria.getEntiteAdministrative()==null?null:criteria.getEntiteAdministrative().getCode());
    }

    public RessourceSpecification(RessourceCriteria criteria) {
        super(criteria);
    }

    public RessourceSpecification(RessourceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
