package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.MaterielCriteria;
import ma.sir.pmp.bean.core.Materiel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MaterielSpecification extends  AbstractSpecification<MaterielCriteria, Materiel>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("quantite", criteria.getQuantite(),criteria.getQuantiteLike());
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateFk("categorieMateriel","id", criteria.getCategorieMateriel()==null?null:criteria.getCategorieMateriel().getId());
        addPredicateFk("categorieMateriel","id", criteria.getCategorieMateriels());
        addPredicateFk("categorieMateriel","reference", criteria.getCategorieMateriel()==null?null:criteria.getCategorieMateriel().getReference());
    }

    public MaterielSpecification(MaterielCriteria criteria) {
        super(criteria);
    }

    public MaterielSpecification(MaterielCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
