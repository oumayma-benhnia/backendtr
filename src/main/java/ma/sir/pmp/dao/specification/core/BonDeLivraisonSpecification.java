package ma.sir.pmp.dao.specification.core;



import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.dao.criteria.core.BonDeLivraisonCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BonDeLivraisonSpecification extends AbstractSpecification<BonDeLivraisonCriteria, BonDeLivraison> {

    @Override
    public void constructPredicates() {
        addPredicate("reference", criteria.getReference(), criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(), criteria.getLibelleLike());
        addPredicate("description", criteria.getDescription(), criteria.getDescriptionLike());
        addPredicate("dateLivraison", criteria.getDateLivraison(), criteria.getDateLivraisonFrom(), criteria.getDateLivraisonTo());
        addPredicate("lieuLivraison", criteria.getLieuLivraison(), criteria.getLieuLivraisonLike());
        addPredicateFk("client", "id", criteria.getClient() == null ? null : criteria.getClient().getId());
        addPredicateFk("client", "id", criteria.getClients());
        addPredicateFk("client","code", criteria.getClient()==null?null:criteria.getClient().getCode());
        addPredicateFk("fournisseur", "id", criteria.getFournisseur() == null ? null : criteria.getFournisseur().getId());
        addPredicateFk("fournisseur", "id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","code", criteria.getFournisseur()==null?null:criteria.getFournisseur().getCode());
    }

    public BonDeLivraisonSpecification(BonDeLivraisonCriteria criteria) {
        super(criteria);
    }

    public BonDeLivraisonSpecification(BonDeLivraisonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}

