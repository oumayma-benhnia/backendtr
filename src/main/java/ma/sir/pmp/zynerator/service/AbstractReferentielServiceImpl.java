package ma.sir.pmp.zynerator.service;

import ma.sir.pmp.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import ma.sir.pmp.zynerator.history.HistCriteria;
import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}