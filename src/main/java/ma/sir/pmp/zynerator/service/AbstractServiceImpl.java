package ma.sir.pmp.zynerator.service;

import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.exception.EntityNotFoundException;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import ma.sir.pmp.zynerator.history.HistCriteria;
import ma.sir.pmp.zynerator.repository.AbstractHistoryRepository;
import ma.sir.pmp.zynerator.repository.AbstractRepository;
import ma.sir.pmp.zynerator.security.bean.User;
import ma.sir.pmp.zynerator.security.service.facade.UserService;
import ma.sir.pmp.zynerator.specification.AbstractHistorySpecification;
import ma.sir.pmp.zynerator.specification.AbstractSpecification;
import ma.sir.pmp.zynerator.util.ListUtil;
import ma.sir.pmp.zynerator.util.RefelexivityUtil;
import ma.sir.pmp.zynerator.util.StringUtil;
import ma.sir.pmp.zynerator.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractServiceImpl<T extends AuditBusinessObject, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImplHelper<T> {

    protected AbstractSpecification<CRITERIA, T> specification;
    protected Class<? extends AbstractSpecification<CRITERIA, T>> specificationClass;

    protected HISTREPO historyRepository;
    protected Class<H> historyClass;
    protected Class<HC> historyCriteriaClass;
    protected Class<? extends AbstractHistorySpecification<HC, H>> historySPecificationClass;


    protected REPO dao;
    @Autowired
    protected UserService userService;

    protected Class<T> itemClass;

    public AbstractServiceImpl(REPO dao, HISTREPO historyRepository) {
        this.dao = dao;
        this.historyRepository = historyRepository;
        this.configure();
    }


    public void deleteAssociatedLists(Long id) {
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public T create(T t) {
        T saved = dao.save(t);
        return t;
    }
    /*

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DTO create(DTO dto) {
        T t = converter.toItem(dto);
        T saved = dao.save(t);
        dto.setId(saved.getId());
        return dto;
    }
    */

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<T> create(List<T> ts) {
        List<T> result = new ArrayList<>();
        if (ts != null) {
            for (T t : ts) {
                if (t.getId() == null || findById(t.getId()) == null) {
                    dao.save(t);
                } else {
                    result.add(t);
                }
            }
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<T> update(List<T> ts, boolean createIfNotExist) {
        List<T> result = new ArrayList<>();
        if (ts != null) {
            for (T t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    T loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }

    /*  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<DTO> create(List<DTO> dtos) {
        if (dtos != null) {
            for (DTO dto : dtos) {
                create(dto);
            }
        }
        return dtos;
    }
    */

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public T update(T t) {
        //saveAuditData(t, ACTION_TYPE.UPDATE);
        T loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{itemClass.getSimpleName(), t.getId().toString()});
        } else {
            //Utils.copyNonNullProperties(t, loadedItem);
            //dao.saveAndFlush(loadedItem);
            updateWithAssociatedLists(t);
            dao.save(t);
            return loadedItem;
        }
    }

    public T findById(Long id) {
        Optional<T> item = dao.findById(id);
        return item.orElse(null);
    }

    public T findByReferenceEntity(T t) {
        return findById(t.getId());
    }

    public T findOrSave(T t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            T result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }

    public void findOrSaveAssociatedObject(T t) {

    }

    public List<T> importerData(List<T> items) {
        List<T> list = new ArrayList<>();
        for (T t : items) {
            T founded = findByReferenceEntity(t);
            if (founded == null) {
                findOrSaveAssociatedObject(t);
                dao.save(t);
            } else {
                list.add(founded);
            }
        }
        return list;
    }

    public T findWithAssociatedLists(Long id) {
        return findById(id);
    }

    public void deleteWithAssociatedLists(T t) {
        deleteAssociatedLists(t.getId());
        delete(t);
    }

    public void updateWithAssociatedLists(T t) {

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public void delete(T t) {
        if (t != null) {
            deleteAssociatedLists(t.getId());
            dao.deleteById(t.getId()); // il fait find by id apres delete !!!
            //constructAndSaveHistory(dto, ACTION_TYPE.DELETE); TO DO
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public void delete(List<T> list) {
        if (list != null) {
            for (T t : list) {
                deleteAssociatedLists(t.getId());
                dao.deleteById(t.getId()); // il fait find by id apres delete !!!
                //constructAndSaveHistory(dto, ACTION_TYPE.DELETE); TO DO
            }
        }
    }


    public List<T> findByCriteria(CRITERIA criteria) {
        List<T> content = null;
        if (criteria != null) {
            addEtablissementConstraint(criteria);
            AbstractSpecification<CRITERIA, T> mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }

    public List<T> findPaginatedByCriteria(CRITERIA criteria, int page, int pageSize, String order, String sortField) {
        addEtablissementConstraint(criteria);
        AbstractSpecification<CRITERIA, T> mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(CRITERIA criteria) {
        addEtablissementConstraint(criteria);
        AbstractSpecification<CRITERIA, T> mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }


    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAllOptimized() {
        return dao.findAll();
    }


    private AbstractSpecification<CRITERIA, T> constructSpecification(CRITERIA criteria) {
        AbstractSpecification<CRITERIA, T> mySpecification = RefelexivityUtil.constructObjectUsingOneParam(specificationClass, criteria);
        return mySpecification;
    }

    //****************************** HISTORY

    /*
    public void saveAuditData(DTO dto, ACTION_TYPE action){
    DTO old = abstractConverter.toDto(findById(dto.getId()));
    try {
        if (Utils.compareObjectsDiff(dto, old)) {
            constructAndSaveHistory(dto, action);
        }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void constructAndSaveHistory(DTO dto, ACTION_TYPE action) {
        User currentUser = getCurrentUser();
        H history = RefelexivityUtil.constructObjectUsingDefaultConstr(historyClass);
        history.setActionType(action.name());
        history.setObjectName(itemClass.getSimpleName());
        history.setObjectId(dto.getId());
        history.setUserId(currentUser.getId());
        history.setUsername(currentUser.getUsername());
        String dtoAsJson = null;
        try {
            dtoAsJson = new ObjectMapper().writeValueAsString(dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        history.setData(dtoAsJson);
        history.setDate(LocalDateTime.now());
        historyRepository.save(history);
    }

    */

    public AuditEntityDto findHistoryById(Long id) {
        H h = historyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("errors.notFound", new String[]{historyClass.getSimpleName(), id.toString()}));
        return null;
        //TODO: restore this ==> return (AuditEntityDto) abstractConverter.copyFromHistory(h);
    }


    public List<AuditEntityDto> findHistoryPaginatedByCriteria(HC historyCriteria, int page, int pageSize, String order, String sortField) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        order = StringUtil.isNotEmpty(order) ? order : "desc";
        sortField = StringUtil.isNotEmpty(sortField) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        List<H> content = historyRepository.findAll(mySpecification, pageable).getContent();
        return null;
        //TODO: restore this ==> return content.stream().map(h -> (AuditEntityDto) abstractConverter.copyFromHistory(h)).collect(Collectors.toList());
    }

    public List<AuditEntityDto> findHistoryByCriteria(HC historyCriteria) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        List<H> content = null;
        if (historyCriteria.isPeagable()) {
            Pageable pageable = PageRequest.of(0, historyCriteria.getMaxResults());
            content = historyRepository.findAll(mySpecification, pageable).getContent();
        } else {
            content = historyRepository.findAll(mySpecification);
        }
        return null;
        //TODO: restore this ==> return content.stream().map(h -> (AuditEntityDto) abstractConverter.copyFromHistory(h)).collect(Collectors.toList());
    }

    public int getHistoryDataSize(HC historyCriteria) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        mySpecification.setDistinct(true);
        return ((Long) historyRepository.count(mySpecification)).intValue();
    }

    private AbstractHistorySpecification<HC, H> constructSpecificationHistory(HC hc) {
        AbstractHistorySpecification<HC, H> mySpecification = RefelexivityUtil.constructObjectUsingDefaultConstr(historySPecificationClass);
        mySpecification.setCriteria(hc);
        return mySpecification;
    }

    public void configure(Class<T> itemClass, Class<H> historyClass, Class<HC> historyCriteriaClass, Class<? extends AbstractSpecification<CRITERIA, T>> specificationClass) {
        this.itemClass = itemClass;
        this.historyClass = historyClass;
        this.historyCriteriaClass = historyCriteriaClass;
        this.specificationClass = specificationClass;
    }

    public abstract void configure();


    private void addEtablissementConstraint(CRITERIA criteria) {
        Object userInfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userInfo instanceof User) {
            User currentUser = (User) userInfo;
            criteria.setEtablissementId(currentUser.getEtablissement() != null ? currentUser.getEtablissement().getId() : null);
        }
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof User) {
            return (User) principal;
        } else if (principal != null && principal instanceof String) {
            return userService.findByUsername(principal.toString());
        } else {
            return null;
        }
    }

    public Long getEtablissementId() {
        User currentUser = getCurrentUser();
        Long etablissementId = (currentUser != null && currentUser.getEtablissement() != null) ? currentUser.getEtablissement().getId() : null;
        return etablissementId == null ? 1L : etablissementId; // TODO: if conneceted user is null exception
    }

    //************************************************** UPDATE ***********************************
    public List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList) {
        List<List<T>> result = new ArrayList<>();
        List<T> resultDelete = new ArrayList<>();
        List<T> resultUpdateOrSave = new ArrayList<>();
        if (ListUtil.isEmpty(oldList) && ListUtil.isNotEmpty(newList)) {
            resultUpdateOrSave.addAll(newList);
        } else if (ListUtil.isEmpty(newList) && ListUtil.isNotEmpty(oldList)) {
            resultDelete.addAll(oldList);
        } else if (ListUtil.isNotEmpty(newList) && ListUtil.isNotEmpty(oldList)) {
            for (int i = 0; i < oldList.size(); i++) {
                T myOld = oldList.get(i);
                T t = newList.stream().filter(e -> myOld.equals(e)).findFirst().orElse(null);
                if (t != null) {
                    resultUpdateOrSave.add(t);
                } else {
                    resultDelete.add(myOld);
                }
            }
            for (int i = 0; i < newList.size(); i++) {
                T myNew = newList.get(i);
                T t = oldList.stream().filter(e -> myNew.equals(e)).findFirst().orElse(null);
                if (t == null) {
                    resultUpdateOrSave.add(myNew);
                }
            }
        }
        result.add(resultUpdateOrSave);
        result.add(resultDelete);
        return result;
    }
}