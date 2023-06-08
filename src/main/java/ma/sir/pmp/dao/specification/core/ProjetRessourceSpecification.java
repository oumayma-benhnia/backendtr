package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.ProjetRessourceCriteria;
import ma.sir.pmp.bean.core.ProjetRessource;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjetRessourceSpecification extends  AbstractSpecification<ProjetRessourceCriteria, ProjetRessource>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicate("quantite", criteria.getQuantite(),criteria.getQuantiteLike());
        addPredicateFk("ressource","id", criteria.getRessource()==null?null:criteria.getRessource().getId());
        addPredicateFk("ressource","id", criteria.getRessources());
        addPredicateFk("projet","id", criteria.getProjet()==null?null:criteria.getProjet().getId());
        addPredicateFk("projet","id", criteria.getProjets());
        addPredicateFk("projet","code", criteria.getProjet()==null?null:criteria.getProjet().getCode());
    }

    public ProjetRessourceSpecification(ProjetRessourceCriteria criteria) {
        super(criteria);
    }

    public ProjetRessourceSpecification(ProjetRessourceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
