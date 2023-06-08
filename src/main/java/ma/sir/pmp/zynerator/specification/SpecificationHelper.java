package ma.sir.pmp.zynerator.specification;

import ma.sir.pmp.zynerator.bean.BusinessObject;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import ma.sir.pmp.zynerator.util.ListUtil;
import ma.sir.pmp.zynerator.util.NumberUtil;
import ma.sir.pmp.zynerator.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO : addConstraintAsc et Desc must be enhanced to acced a map of TypeOrder(enum) and attributeName (String)
// in order to respect the order of asc desc constraint

public abstract class SpecificationHelper<Criteria extends BaseCriteria, H extends BusinessObject> implements Specification<H> {

    protected Criteria criteria;
    protected boolean distinct;
    protected Root<H> root;
    protected CriteriaQuery<?> query;
    protected CriteriaBuilder builder;
    protected List<Predicate> predicates;

    public void attachSearchElement(Root<H> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        this.root = root;
        this.query = query;
        this.builder = builder;
        this.predicates = predicates;
    }

    public void addPredicateInt(String name, String value,String valueMin,String valueMax) {
        addPredicateInt(name,value);
        addPredicateInt(name,valueMin,valueMax);
    }
    public void addPredicateBigDecimal(String name, String value, String valueMin, String valueMax) {
        addPredicateBigDecimal(name, value);
        addPredicateBigDecimal(name, valueMin, valueMax);
    }

    public void addPredicate(String name, LocalDateTime value, LocalDateTime valueMin, LocalDateTime valueMax) {
        addPredicate(name, value);
        addPredicate(name, valueMin, valueMax);
    }

    public void addPredicateLong(String name, String value, String valueMin, String valueMax) {
        addPredicate(name, value);
        addPredicateLong(name, valueMin, valueMax);
    }


    public void addPredicate(String name, BaseCriteria baseCriteria) {
        if (baseCriteria != null && baseCriteria.getId() != null) {
            predicates.add(builder.equal(root.<Long>get(name), baseCriteria.getId()));
        }
    }

    public void addPredicate(String name, List<? extends BaseCriteria> baseCriterias) {
        if (baseCriterias != null) {
            List<Long> ids = baseCriterias.stream().map(e->e.getId()).collect(Collectors.toList());
            addPredicateIn(name,ids);
        }
    }

    public void addPredicate(String name, Long value) {
        if (NumberUtil.isPostif(value)) {
            predicates.add(builder.equal(root.<Long>get(name), value));
        }
    }


    public void addPredicateIn(String name, List<Long> values) {
        List<Long> results = null;
        if (ListUtil.isNotEmpty(values)) {
            results = values.stream().filter(NumberUtil::isPostif).collect(Collectors.toList());
        }
        if (ListUtil.isNotEmpty(results) && results.size() == 1) {
            addPredicate(name, results.get(0));
        } else if (ListUtil.isNotEmpty(results) && results.size() > 1) {
            predicates.add(root.<Long>get(name).in(values));
        }
    }

    public void addPredicateDouble(String name, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<Double>get(name), Double.parseDouble(value)));
        }
    }
    public void addPredicateBigDecimal(String name, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<BigDecimal>get(name), new BigDecimal(value)));
        }
    }
    public void addPredicateId(String name, BaseCriteria baseCriteria) {
        if (baseCriteria != null) {
            addPredicateLong(name, baseCriteria.getId());
            addPredicateNot(name, baseCriteria.getNotId());
            addPredicateIn(name, baseCriteria.getIdsIn());
            addPredicateNotIn(name, baseCriteria.getIdsNotIn());
        }
    }

    private void addPredicateId(String name, Long value, Long valueNot, List<Long> idsIn, List<Long> idsNotIn) {
        addPredicate(name, value);
        addPredicateNot(name, valueNot);
        addPredicateIn(name, idsIn);
        addPredicateNotIn(name, idsNotIn);
    }

    public void addPredicateLong(String name, Long value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<Long>get(name), value));
        }
    }

    public void addPredicateNot(String name, Long value) {
        if (NumberUtil.isPostif(value)) {
            predicates.add(builder.notEqual(root.<Boolean>get(name), value));
        }
    }

    public void addPredicate(String name, String value, String valueLike) {
        if (StringUtil.isNotEmpty(valueLike)) {
            predicates.add(builder.like(builder.lower(root.get(name)), "%" + valueLike + "%"));

        } else if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<String>get(name), value));
        }
    }

    public void addPredicate(String name, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<String>get(name), value));
        }
    }

    public void addPredicate(String name, LocalDateTime value) {
        if (value != null) {
            predicates.add(builder.equal(root.<LocalDateTime>get(name), value));
        }
    }

    public void addPredicateInt(String name, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<Integer>get(name), Integer.parseInt(value)));
        }
    }

    public void addPredicateLong(String name, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.<Long>get(name), Long.parseLong(value)));
        }
    }

    public void addPredicateBool(String name, Boolean value) {
        if (value!=null) {
            predicates.add(builder.equal(root.<Boolean>get(name), value));
        }
    }


    public void addPredicate(String name, LocalDateTime valueMin, LocalDateTime valueMax) {
        if (valueMin != null && valueMax != null) {
            predicates.add(builder.between(root.get(name), valueMin, valueMax));
        } else if (valueMin != null) {
            predicates.add(builder.greaterThan(root.get(name), valueMin));
        } else if (valueMax != null) {
            predicates.add(builder.lessThan(root.get(name), valueMax));
        }
    }

    public void addPredicateNotIn(String name, List<Long> values) {
        if (ListUtil.isNotEmpty(values)) {
            predicates.add(builder.not(root.<Long>get(name).in(values)));
        }
    }

    public void addPredicateBigDecimal(String name, String valueMin,String valueMax) {
        if (StringUtil.isNotEmpty(valueMin)) {
            predicates.add(builder.greaterThanOrEqualTo(root.<BigDecimal>get(name), new BigDecimal(valueMin)));
        } if (StringUtil.isNotEmpty(valueMax)) {
            predicates.add(builder.lessThanOrEqualTo(root.<BigDecimal>get(name), new BigDecimal(valueMax)));
        }
    }
    public void addPredicateDouble(String name, String valueMin,String valueMax) {
        if (StringUtil.isNotEmpty(valueMin)) {
            predicates.add(builder.greaterThanOrEqualTo(root.<Double>get(name), Double.valueOf(valueMin)));
        } if (StringUtil.isNotEmpty(valueMax)) {
            predicates.add(builder.lessThanOrEqualTo(root.<Double>get(name),  Double.valueOf(valueMax)));
        }
    }
    public void addPredicateLong(String name, String valueMin,String valueMax) {
        if (StringUtil.isNotEmpty(valueMin)) {
            predicates.add(builder.greaterThanOrEqualTo(root.<Long>get(name), Long.valueOf(valueMin)));
        } if (StringUtil.isNotEmpty(valueMax)) {
            predicates.add(builder.lessThanOrEqualTo(root.<Long>get(name), Long.valueOf(valueMax)));
        }
    }
    public void addPredicateInt(String name, String valueMin,String valueMax) {
        if (StringUtil.isNotEmpty(valueMin)) {
            predicates.add(builder.greaterThanOrEqualTo(root.<Integer>get(name), Integer.valueOf(valueMin)));
        } if (StringUtil.isNotEmpty(valueMax)) {
            predicates.add(builder.lessThanOrEqualTo(root.<Integer>get(name), Integer.valueOf(valueMax)));
        }
    }


    public List<Long> getIds(List<? extends BaseCriteria> list) {
        if(list == null){
            return new ArrayList<>();
        }else{
            return list.stream().map(e->e.getId()).collect(Collectors.toList());
        }
    }

    public void addPredicateFk(String nameObject,String nameAttribute, List<? extends  BaseCriteria> list) {
        List<Long> ids = getIds(list);
        if (ListUtil.isNotEmpty(ids) && ids.size() == 1) {
            addPredicateFk(nameObject, nameAttribute,ids.get(0));
        } else if (ListUtil.isNotEmpty(ids) && ids.size() > 1) {
            predicates.add(root.get(nameObject).get(nameAttribute).in(ids));
        }
    }

    public void addPredicateFk(String nameObject, String nameAttribute, String value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.get(nameObject).get(nameAttribute), value));
        }
    }
    public void addPredicateFk(String nameObject, String nameAttribute, Boolean value) {
        if (value != null) {
            predicates.add(builder.equal(root.get(nameObject).get(nameAttribute), value));
        }
    }

    public void addPredicateFk(String nameObject, String nameAttribute, Long value) {
        if (StringUtil.isNotEmpty(value)) {
            predicates.add(builder.equal(root.get(nameObject).get(nameAttribute), value));
        }
    }
    public void addOrderAndFilter() {
        addFilterConstraint();
        addOrderByAscConstraint();
        addOrderByDescConstraint();
    }

    private void addOrderByDescConstraint() {
        if (StringUtil.isNotEmpty(criteria.getOrderByDesc())) {
            List<Order> orderList = new ArrayList();
            for (int i = 0; i < criteria.getOrderByDesc().length; i++) {
                orderList.add(builder.desc(root.get(criteria.getOrderByDesc()[i])));
            }
            query.orderBy(orderList);
        }
    }

    private void addOrderByAscConstraint() {
        if (StringUtil.isNotEmpty(criteria.getOrderByAsc())) {
            List<Order> orderList = new ArrayList();
            for (int i = 0; i < criteria.getOrderByAsc().length; i++) {
                orderList.add(builder.asc(root.get(criteria.getOrderByAsc()[i])));
            }
            query.orderBy(orderList);
        }
    }

    private void addFilterConstraint() {
        if (StringUtil.isNotEmpty(criteria.getFilterName()) && StringUtil.isNotEmpty(criteria.getFilterWord())) {
            Expression<String> path = root.get(criteria.getFilterName());
            Expression<String> lower = builder.lower(path);
            predicates.add(builder.like(lower, "%" + criteria.getFilterWord().toLowerCase() + "%"));
        }
    }

    public Predicate getResult() {
        if (distinct)
            query.distinct(true);
        return builder.and(predicates.toArray(new Predicate[0]));
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

}
