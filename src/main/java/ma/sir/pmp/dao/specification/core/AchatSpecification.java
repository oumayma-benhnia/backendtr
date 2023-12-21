package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Achat;
import ma.sir.pmp.dao.criteria.core.AchatCriteria;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;

public class AchatSpecification extends AbstractSpecification<AchatCriteria, Achat> {
    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("dateAchat", criteria.getDateAchat(), criteria.getDateAchatFrom(), criteria.getDateAchatTo());
        addPredicateFk("materiel","id", criteria.getMateriel()==null?null:criteria.getMateriel().getId());
        addPredicateFk("materiel","id", criteria.getMateriels());
        addPredicateFk("materiel","reference", criteria.getMateriel()==null?null:criteria.getMateriel().getReference());
        addPredicateFk("fournisseur","id", criteria.getFournisseur()==null?null:criteria.getFournisseur().getId());
        addPredicateFk("fournisseur","id", criteria.getFournisseurs());
        addPredicateFk("fournisseur","code", criteria.getFournisseur()==null?null:criteria.getFournisseur().getCode());
    }

    public AchatSpecification(AchatCriteria criteria) {
        super(criteria);
    }

    public AchatSpecification(AchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }
}
