package  ma.sir.pmp.dao.specification.history;

import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.dao.criteria.history.TypeDeclarationHistoryCriteria;
import ma.sir.pmp.bean.history.TypeDeclarationHistory;


public class TypeDeclarationHistorySpecification extends AbstractHistorySpecification<TypeDeclarationHistoryCriteria, TypeDeclarationHistory> {

    public TypeDeclarationHistorySpecification(TypeDeclarationHistoryCriteria criteria) {
        super(criteria);
    }

    public TypeDeclarationHistorySpecification(TypeDeclarationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
