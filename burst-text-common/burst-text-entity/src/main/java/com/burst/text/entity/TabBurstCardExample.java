package com.burst.text.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabBurstCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabBurstCardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBurstIdIsNull() {
            addCriterion("burst_id is null");
            return (Criteria) this;
        }

        public Criteria andBurstIdIsNotNull() {
            addCriterion("burst_id is not null");
            return (Criteria) this;
        }

        public Criteria andBurstIdEqualTo(String value) {
            addCriterion("burst_id =", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdNotEqualTo(String value) {
            addCriterion("burst_id <>", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdGreaterThan(String value) {
            addCriterion("burst_id >", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdGreaterThanOrEqualTo(String value) {
            addCriterion("burst_id >=", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdLessThan(String value) {
            addCriterion("burst_id <", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdLessThanOrEqualTo(String value) {
            addCriterion("burst_id <=", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdLike(String value) {
            addCriterion("burst_id like", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdNotLike(String value) {
            addCriterion("burst_id not like", value, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdIn(List<String> values) {
            addCriterion("burst_id in", values, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdNotIn(List<String> values) {
            addCriterion("burst_id not in", values, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdBetween(String value1, String value2) {
            addCriterion("burst_id between", value1, value2, "burstId");
            return (Criteria) this;
        }

        public Criteria andBurstIdNotBetween(String value1, String value2) {
            addCriterion("burst_id not between", value1, value2, "burstId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdIsNull() {
            addCriterion("card_up_id is null");
            return (Criteria) this;
        }

        public Criteria andCardUpIdIsNotNull() {
            addCriterion("card_up_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardUpIdEqualTo(String value) {
            addCriterion("card_up_id =", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdNotEqualTo(String value) {
            addCriterion("card_up_id <>", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdGreaterThan(String value) {
            addCriterion("card_up_id >", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_up_id >=", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdLessThan(String value) {
            addCriterion("card_up_id <", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdLessThanOrEqualTo(String value) {
            addCriterion("card_up_id <=", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdLike(String value) {
            addCriterion("card_up_id like", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdNotLike(String value) {
            addCriterion("card_up_id not like", value, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdIn(List<String> values) {
            addCriterion("card_up_id in", values, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdNotIn(List<String> values) {
            addCriterion("card_up_id not in", values, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdBetween(String value1, String value2) {
            addCriterion("card_up_id between", value1, value2, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardUpIdNotBetween(String value1, String value2) {
            addCriterion("card_up_id not between", value1, value2, "cardUpId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdIsNull() {
            addCriterion("card_foot_id is null");
            return (Criteria) this;
        }

        public Criteria andCardFootIdIsNotNull() {
            addCriterion("card_foot_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardFootIdEqualTo(String value) {
            addCriterion("card_foot_id =", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdNotEqualTo(String value) {
            addCriterion("card_foot_id <>", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdGreaterThan(String value) {
            addCriterion("card_foot_id >", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_foot_id >=", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdLessThan(String value) {
            addCriterion("card_foot_id <", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdLessThanOrEqualTo(String value) {
            addCriterion("card_foot_id <=", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdLike(String value) {
            addCriterion("card_foot_id like", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdNotLike(String value) {
            addCriterion("card_foot_id not like", value, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdIn(List<String> values) {
            addCriterion("card_foot_id in", values, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdNotIn(List<String> values) {
            addCriterion("card_foot_id not in", values, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdBetween(String value1, String value2) {
            addCriterion("card_foot_id between", value1, value2, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCardFootIdNotBetween(String value1, String value2) {
            addCriterion("card_foot_id not between", value1, value2, "cardFootId");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}