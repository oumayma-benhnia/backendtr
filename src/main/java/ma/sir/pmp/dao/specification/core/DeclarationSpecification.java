package  ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.DeclarationCriteria;
import ma.sir.pmp.bean.core.Declaration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeclarationSpecification extends  AbstractSpecification<DeclarationCriteria, Declaration>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("typeDeclaration","id", criteria.getTypeDeclaration()==null?null:criteria.getTypeDeclaration().getId());
        addPredicateFk("typeDeclaration","id", criteria.getTypeDeclarations());
        addPredicateFk("typeDeclaration","reference", criteria.getTypeDeclaration()==null?null:criteria.getTypeDeclaration().getReference());
    }

    public DeclarationSpecification(DeclarationCriteria criteria) {
        super(criteria);
    }

    public DeclarationSpecification(DeclarationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
