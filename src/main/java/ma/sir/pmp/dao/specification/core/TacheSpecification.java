package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.TacheCriteria;
import ma.sir.pmp.bean.core.Tache;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TacheSpecification extends  AbstractSpecification<TacheCriteria, Tache>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("tele", criteria.getTele(),criteria.getTeleLike());
        addPredicate("titre", criteria.getTitre(),criteria.getTitreLike());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","code", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getCode());
    }

    public TacheSpecification(TacheCriteria criteria) {
        super(criteria);
    }

    public TacheSpecification(TacheCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
