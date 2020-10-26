package com.macro.mall.example;

import com.macro.mall.model.YxxOrder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YxxOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxxOrderExample() {
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

    public YxxOrderExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public YxxOrderExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static Criteria newAndCreateCriteria() {
        YxxOrderExample example = new YxxOrderExample();
        return example.createCriteria();
    }

    public YxxOrderExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public YxxOrderExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_sn <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNull() {
            addCriterion("tel_no is null");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNotNull() {
            addCriterion("tel_no is not null");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualTo(String value) {
            addCriterion("tel_no =", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualTo(String value) {
            addCriterion("tel_no <>", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThan(String value) {
            addCriterion("tel_no >", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualTo(String value) {
            addCriterion("tel_no >=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoLessThan(String value) {
            addCriterion("tel_no <", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualTo(String value) {
            addCriterion("tel_no <=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("tel_no <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTelNoLike(String value) {
            addCriterion("tel_no like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotLike(String value) {
            addCriterion("tel_no not like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoIn(List<String> values) {
            addCriterion("tel_no in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotIn(List<String> values) {
            addCriterion("tel_no not in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoBetween(String value1, String value2) {
            addCriterion("tel_no between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotBetween(String value1, String value2) {
            addCriterion("tel_no not between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNull() {
            addCriterion("member_sex is null");
            return (Criteria) this;
        }

        public Criteria andMemberSexIsNotNull() {
            addCriterion("member_sex is not null");
            return (Criteria) this;
        }

        public Criteria andMemberSexEqualTo(Integer value) {
            addCriterion("member_sex =", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexNotEqualTo(Integer value) {
            addCriterion("member_sex <>", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThan(Integer value) {
            addCriterion("member_sex >", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_sex >=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThan(Integer value) {
            addCriterion("member_sex <", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThanOrEqualTo(Integer value) {
            addCriterion("member_sex <=", value, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("member_sex <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberSexIn(List<Integer> values) {
            addCriterion("member_sex in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotIn(List<Integer> values) {
            addCriterion("member_sex not in", values, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexBetween(Integer value1, Integer value2) {
            addCriterion("member_sex between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andMemberSexNotBetween(Integer value1, Integer value2) {
            addCriterion("member_sex not between", value1, value2, "memberSex");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("product_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("sku_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNull() {
            addCriterion("worker_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNotNull() {
            addCriterion("worker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualTo(Long value) {
            addCriterion("worker_id =", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(Long value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(Long value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(Long value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("worker_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdIn(List<Long> values) {
            addCriterion("worker_id in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotIn(List<Long> values) {
            addCriterion("worker_id not in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdBetween(Long value1, Long value2) {
            addCriterion("worker_id between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            addCriterion("worker_id not between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("`location` is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("`location` is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("`location` =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("`location` <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("`location` >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("`location` >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("`location` <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("`location` <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("`location` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("`location` like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("`location` not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("`location` in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("`location` not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("`location` between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("`location` not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("address <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("detail_address <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartIsNull() {
            addCriterion("visit_time_start is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartIsNotNull() {
            addCriterion("visit_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartEqualTo(Date value) {
            addCriterion("visit_time_start =", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartNotEqualTo(Date value) {
            addCriterion("visit_time_start <>", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartGreaterThan(Date value) {
            addCriterion("visit_time_start >", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time_start >=", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartLessThan(Date value) {
            addCriterion("visit_time_start <", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("visit_time_start <=", value, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_start <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartIn(List<Date> values) {
            addCriterion("visit_time_start in", values, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartNotIn(List<Date> values) {
            addCriterion("visit_time_start not in", values, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartBetween(Date value1, Date value2) {
            addCriterion("visit_time_start between", value1, value2, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("visit_time_start not between", value1, value2, "visitTimeStart");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndIsNull() {
            addCriterion("visit_time_end is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndIsNotNull() {
            addCriterion("visit_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndEqualTo(Date value) {
            addCriterion("visit_time_end =", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndNotEqualTo(Date value) {
            addCriterion("visit_time_end <>", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndGreaterThan(Date value) {
            addCriterion("visit_time_end >", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("visit_time_end >=", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndLessThan(Date value) {
            addCriterion("visit_time_end <", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("visit_time_end <=", value, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("visit_time_end <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndIn(List<Date> values) {
            addCriterion("visit_time_end in", values, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndNotIn(List<Date> values) {
            addCriterion("visit_time_end not in", values, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndBetween(Date value1, Date value2) {
            addCriterion("visit_time_end between", value1, value2, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("visit_time_end not between", value1, value2, "visitTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("remark <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPhotosIsNull() {
            addCriterion("photos is null");
            return (Criteria) this;
        }

        public Criteria andPhotosIsNotNull() {
            addCriterion("photos is not null");
            return (Criteria) this;
        }

        public Criteria andPhotosEqualTo(String value) {
            addCriterion("photos =", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosNotEqualTo(String value) {
            addCriterion("photos <>", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosGreaterThan(String value) {
            addCriterion("photos >", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosGreaterThanOrEqualTo(String value) {
            addCriterion("photos >=", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosLessThan(String value) {
            addCriterion("photos <", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosLessThanOrEqualTo(String value) {
            addCriterion("photos <=", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("photos <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhotosLike(String value) {
            addCriterion("photos like", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosNotLike(String value) {
            addCriterion("photos not like", value, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosIn(List<String> values) {
            addCriterion("photos in", values, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosNotIn(List<String> values) {
            addCriterion("photos not in", values, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosBetween(String value1, String value2) {
            addCriterion("photos between", value1, value2, "photos");
            return (Criteria) this;
        }

        public Criteria andPhotosNotBetween(String value1, String value2) {
            addCriterion("photos not between", value1, value2, "photos");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("coupon_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Long> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andIsBargainIsNull() {
            addCriterion("is_bargain is null");
            return (Criteria) this;
        }

        public Criteria andIsBargainIsNotNull() {
            addCriterion("is_bargain is not null");
            return (Criteria) this;
        }

        public Criteria andIsBargainEqualTo(Integer value) {
            addCriterion("is_bargain =", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainNotEqualTo(Integer value) {
            addCriterion("is_bargain <>", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThan(Integer value) {
            addCriterion("is_bargain >", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_bargain >=", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThan(Integer value) {
            addCriterion("is_bargain <", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanOrEqualTo(Integer value) {
            addCriterion("is_bargain <=", value, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_bargain <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsBargainIn(List<Integer> values) {
            addCriterion("is_bargain in", values, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotIn(List<Integer> values) {
            addCriterion("is_bargain not in", values, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainBetween(Integer value1, Integer value2) {
            addCriterion("is_bargain between", value1, value2, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsBargainNotBetween(Integer value1, Integer value2) {
            addCriterion("is_bargain not between", value1, value2, "isBargain");
            return (Criteria) this;
        }

        public Criteria andIsTransferIsNull() {
            addCriterion("is_transfer is null");
            return (Criteria) this;
        }

        public Criteria andIsTransferIsNotNull() {
            addCriterion("is_transfer is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransferEqualTo(Integer value) {
            addCriterion("is_transfer =", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferNotEqualTo(Integer value) {
            addCriterion("is_transfer <>", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferGreaterThan(Integer value) {
            addCriterion("is_transfer >", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_transfer >=", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferLessThan(Integer value) {
            addCriterion("is_transfer <", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferLessThanOrEqualTo(Integer value) {
            addCriterion("is_transfer <=", value, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("is_transfer <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsTransferIn(List<Integer> values) {
            addCriterion("is_transfer in", values, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferNotIn(List<Integer> values) {
            addCriterion("is_transfer not in", values, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferBetween(Integer value1, Integer value2) {
            addCriterion("is_transfer between", value1, value2, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andIsTransferNotBetween(Integer value1, Integer value2) {
            addCriterion("is_transfer not between", value1, value2, "isTransfer");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("cancel_reason <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonIsNull() {
            addCriterion("pause_reason is null");
            return (Criteria) this;
        }

        public Criteria andPauseReasonIsNotNull() {
            addCriterion("pause_reason is not null");
            return (Criteria) this;
        }

        public Criteria andPauseReasonEqualTo(String value) {
            addCriterion("pause_reason =", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonNotEqualTo(String value) {
            addCriterion("pause_reason <>", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonGreaterThan(String value) {
            addCriterion("pause_reason >", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("pause_reason >=", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonLessThan(String value) {
            addCriterion("pause_reason <", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonLessThanOrEqualTo(String value) {
            addCriterion("pause_reason <=", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pause_reason <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPauseReasonLike(String value) {
            addCriterion("pause_reason like", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonNotLike(String value) {
            addCriterion("pause_reason not like", value, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonIn(List<String> values) {
            addCriterion("pause_reason in", values, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonNotIn(List<String> values) {
            addCriterion("pause_reason not in", values, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonBetween(String value1, String value2) {
            addCriterion("pause_reason between", value1, value2, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andPauseReasonNotBetween(String value1, String value2) {
            addCriterion("pause_reason not between", value1, value2, "pauseReason");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNull() {
            addCriterion("offer_price is null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNotNull() {
            addCriterion("offer_price is not null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceEqualTo(BigDecimal value) {
            addCriterion("offer_price =", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotEqualTo(BigDecimal value) {
            addCriterion("offer_price <>", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThan(BigDecimal value) {
            addCriterion("offer_price >", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_price >=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThan(BigDecimal value) {
            addCriterion("offer_price <", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_price <=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("offer_price <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOfferPriceIn(List<BigDecimal> values) {
            addCriterion("offer_price in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotIn(List<BigDecimal> values) {
            addCriterion("offer_price not in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_price between", value1, value2, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_price not between", value1, value2, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("discount_price <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNull() {
            addCriterion("pay_price is null");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNotNull() {
            addCriterion("pay_price is not null");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualTo(BigDecimal value) {
            addCriterion("pay_price =", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualTo(BigDecimal value) {
            addCriterion("pay_price <>", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThan(BigDecimal value) {
            addCriterion("pay_price >", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price >=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThan(BigDecimal value) {
            addCriterion("pay_price <", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price <=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("pay_price <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPayPriceIn(List<BigDecimal> values) {
            addCriterion("pay_price in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotIn(List<BigDecimal> values) {
            addCriterion("pay_price not in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price not between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("create_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("update_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andZoneIdIsNull() {
            addCriterion("zone_id is null");
            return (Criteria) this;
        }

        public Criteria andZoneIdIsNotNull() {
            addCriterion("zone_id is not null");
            return (Criteria) this;
        }

        public Criteria andZoneIdEqualTo(Long value) {
            addCriterion("zone_id =", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdNotEqualTo(Long value) {
            addCriterion("zone_id <>", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdGreaterThan(Long value) {
            addCriterion("zone_id >", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdGreaterThanOrEqualTo(Long value) {
            addCriterion("zone_id >=", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdLessThan(Long value) {
            addCriterion("zone_id <", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdLessThanOrEqualTo(Long value) {
            addCriterion("zone_id <=", value, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("zone_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andZoneIdIn(List<Long> values) {
            addCriterion("zone_id in", values, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdNotIn(List<Long> values) {
            addCriterion("zone_id not in", values, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdBetween(Long value1, Long value2) {
            addCriterion("zone_id between", value1, value2, "zoneId");
            return (Criteria) this;
        }

        public Criteria andZoneIdNotBetween(Long value1, Long value2) {
            addCriterion("zone_id not between", value1, value2, "zoneId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Long value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Long value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Long value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Long value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("region_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Long> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Long> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Long value1, Long value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("order_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andPriceJsonIsNull() {
            addCriterion("price_json is null");
            return (Criteria) this;
        }

        public Criteria andPriceJsonIsNotNull() {
            addCriterion("price_json is not null");
            return (Criteria) this;
        }

        public Criteria andPriceJsonEqualTo(String value) {
            addCriterion("price_json =", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonNotEqualTo(String value) {
            addCriterion("price_json <>", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonNotEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonGreaterThan(String value) {
            addCriterion("price_json >", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonGreaterThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonGreaterThanOrEqualTo(String value) {
            addCriterion("price_json >=", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonGreaterThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonLessThan(String value) {
            addCriterion("price_json <", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonLessThanColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonLessThanOrEqualTo(String value) {
            addCriterion("price_json <=", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonLessThanOrEqualToColumn(YxxOrder.Column column) {
            addCriterion(new StringBuilder("price_json <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPriceJsonLike(String value) {
            addCriterion("price_json like", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonNotLike(String value) {
            addCriterion("price_json not like", value, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonIn(List<String> values) {
            addCriterion("price_json in", values, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonNotIn(List<String> values) {
            addCriterion("price_json not in", values, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonBetween(String value1, String value2) {
            addCriterion("price_json between", value1, value2, "priceJson");
            return (Criteria) this;
        }

        public Criteria andPriceJsonNotBetween(String value1, String value2) {
            addCriterion("price_json not between", value1, value2, "priceJson");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private YxxOrderExample example;

        protected Criteria(YxxOrderExample example) {
            super();
            this.example = example;
        }

        public YxxOrderExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.macro.mall.example.YxxOrderExample example);
    }
}