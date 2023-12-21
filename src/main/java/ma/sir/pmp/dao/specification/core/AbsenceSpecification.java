package ma.sir.pmp.dao.specification.core;

import ma.sir.pmp.bean.core.Absence;
import ma.sir.pmp.dao.criteria.core.AbsenceCriteria;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;

public class AbsenceSpecification extends AbstractSpecification<AbsenceCriteria, Absence> {


    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("employe","id", criteria.getEmploye()==null?null:criteria.getEmploye().getId());
        addPredicateFk("employe","id", criteria.getEmployes());
        addPredicateFk("employe","code", criteria.getEmploye()==null?null:criteria.getEmploye().getCode());
        addPredicateFk("chefProjet","id", criteria.getChefProjet()==null?null:criteria.getChefProjet().getId());
        addPredicateFk("chefProjet","id", criteria.getChefProjets());
        addPredicateFk("chefProjet","code", criteria.getChefProjet()==null?null:criteria.getChefProjet().getCode());
        addPredicateFk("stagaire","id", criteria.getStagaire()==null?null:criteria.getStagaire().getId());
        addPredicateFk("stagaire","id", criteria.getStagaires());
        addPredicateFk("stagaire","code", criteria.getStagaire()==null?null:criteria.getStagaire().getCode());
        addPredicate("dateAbsence", criteria.getDateAbsence(), criteria.getDateAbsenceFrom(), criteria.getDateAbsenceTo());


    }

    public AbsenceSpecification(AbsenceCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

    public AbsenceSpecification(AbsenceCriteria criteria) {
        super(criteria);
    }
}
