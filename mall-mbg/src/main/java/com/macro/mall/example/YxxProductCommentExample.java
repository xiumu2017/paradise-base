package com.macro.mall.example;

import com.macro.mall.model.YxxProductComment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YxxProductCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxxProductCommentExample() {
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

    public YxxProductCommentExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public YxxProductCommentExample orderBy(String ... orderByClauses) {
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
        YxxProductCommentExample example = new YxxProductCommentExample();
        return example.createCriteria();
    }

    public YxxProductCommentExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public YxxProductCommentExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(YxxProductComment.Column column) {
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

        public Criteria andProductIdEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualToColumn(YxxProductComment.Column column) {
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

        public Criteria andMemberIdEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualToColumn(YxxProductComment.Column column) {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("order_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andSkuIdEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualToColumn(YxxProductComment.Column column) {
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

        public Criteria andMemberNameEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualToColumn(YxxProductComment.Column column) {
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("product_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNull() {
            addCriterion("sku_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNotNull() {
            addCriterion("sku_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualTo(String value) {
            addCriterion("sku_name =", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualTo(String value) {
            addCriterion("sku_name <>", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThan(String value) {
            addCriterion("sku_name >", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_name >=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThan(String value) {
            addCriterion("sku_name <", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualTo(String value) {
            addCriterion("sku_name <=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("sku_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andSkuNameLike(String value) {
            addCriterion("sku_name like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotLike(String value) {
            addCriterion("sku_name not like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIn(List<String> values) {
            addCriterion("sku_name in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotIn(List<String> values) {
            addCriterion("sku_name not in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameBetween(String value1, String value2) {
            addCriterion("sku_name between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotBetween(String value1, String value2) {
            addCriterion("sku_name not between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(Integer value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Integer value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Integer value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Integer value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Integer value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("star <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Integer> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Integer> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Integer value1, Integer value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Integer value1, Integer value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Integer value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Integer value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Integer value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Integer value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("show_status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Integer> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Integer> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Integer value1, Integer value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collect_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collect_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Integer value) {
            addCriterion("collect_count =", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Integer value) {
            addCriterion("collect_count <>", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Integer value) {
            addCriterion("collect_count >", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_count >=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Integer value) {
            addCriterion("collect_count <", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_count <=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("collect_count <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Integer> values) {
            addCriterion("collect_count in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Integer> values) {
            addCriterion("collect_count not in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_count between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_count not between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("read_count <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountIsNull() {
            addCriterion("love_count is null");
            return (Criteria) this;
        }

        public Criteria andLoveCountIsNotNull() {
            addCriterion("love_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoveCountEqualTo(Integer value) {
            addCriterion("love_count =", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountNotEqualTo(Integer value) {
            addCriterion("love_count <>", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThan(Integer value) {
            addCriterion("love_count >", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("love_count >=", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThan(Integer value) {
            addCriterion("love_count <", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThanOrEqualTo(Integer value) {
            addCriterion("love_count <=", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("love_count <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLoveCountIn(List<Integer> values) {
            addCriterion("love_count in", values, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotIn(List<Integer> values) {
            addCriterion("love_count not in", values, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountBetween(Integer value1, Integer value2) {
            addCriterion("love_count between", value1, value2, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("love_count not between", value1, value2, "loveCount");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("content <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPicsIsNull() {
            addCriterion("pics is null");
            return (Criteria) this;
        }

        public Criteria andPicsIsNotNull() {
            addCriterion("pics is not null");
            return (Criteria) this;
        }

        public Criteria andPicsEqualTo(String value) {
            addCriterion("pics =", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualTo(String value) {
            addCriterion("pics <>", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThan(String value) {
            addCriterion("pics >", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualTo(String value) {
            addCriterion("pics >=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsLessThan(String value) {
            addCriterion("pics <", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualTo(String value) {
            addCriterion("pics <=", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("pics <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicsLike(String value) {
            addCriterion("pics like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotLike(String value) {
            addCriterion("pics not like", value, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsIn(List<String> values) {
            addCriterion("pics in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotIn(List<String> values) {
            addCriterion("pics not in", values, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsBetween(String value1, String value2) {
            addCriterion("pics between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andPicsNotBetween(String value1, String value2) {
            addCriterion("pics not between", value1, value2, "pics");
            return (Criteria) this;
        }

        public Criteria andMemberIconIsNull() {
            addCriterion("member_icon is null");
            return (Criteria) this;
        }

        public Criteria andMemberIconIsNotNull() {
            addCriterion("member_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIconEqualTo(String value) {
            addCriterion("member_icon =", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconNotEqualTo(String value) {
            addCriterion("member_icon <>", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconGreaterThan(String value) {
            addCriterion("member_icon >", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconGreaterThanOrEqualTo(String value) {
            addCriterion("member_icon >=", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconLessThan(String value) {
            addCriterion("member_icon <", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconLessThanOrEqualTo(String value) {
            addCriterion("member_icon <=", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("member_icon <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andMemberIconLike(String value) {
            addCriterion("member_icon like", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconNotLike(String value) {
            addCriterion("member_icon not like", value, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconIn(List<String> values) {
            addCriterion("member_icon in", values, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconNotIn(List<String> values) {
            addCriterion("member_icon not in", values, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconBetween(String value1, String value2) {
            addCriterion("member_icon between", value1, value2, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andMemberIconNotBetween(String value1, String value2) {
            addCriterion("member_icon not between", value1, value2, "memberIcon");
            return (Criteria) this;
        }

        public Criteria andIsReplayIsNull() {
            addCriterion("is_replay is null");
            return (Criteria) this;
        }

        public Criteria andIsReplayIsNotNull() {
            addCriterion("is_replay is not null");
            return (Criteria) this;
        }

        public Criteria andIsReplayEqualTo(Integer value) {
            addCriterion("is_replay =", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayNotEqualTo(Integer value) {
            addCriterion("is_replay <>", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayGreaterThan(Integer value) {
            addCriterion("is_replay >", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_replay >=", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayLessThan(Integer value) {
            addCriterion("is_replay <", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayLessThanOrEqualTo(Integer value) {
            addCriterion("is_replay <=", value, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("is_replay <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIsReplayIn(List<Integer> values) {
            addCriterion("is_replay in", values, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayNotIn(List<Integer> values) {
            addCriterion("is_replay not in", values, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayBetween(Integer value1, Integer value2) {
            addCriterion("is_replay between", value1, value2, "isReplay");
            return (Criteria) this;
        }

        public Criteria andIsReplayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_replay not between", value1, value2, "isReplay");
            return (Criteria) this;
        }

        public Criteria andReplayContentIsNull() {
            addCriterion("replay_content is null");
            return (Criteria) this;
        }

        public Criteria andReplayContentIsNotNull() {
            addCriterion("replay_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplayContentEqualTo(String value) {
            addCriterion("replay_content =", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentNotEqualTo(String value) {
            addCriterion("replay_content <>", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentGreaterThan(String value) {
            addCriterion("replay_content >", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentGreaterThanOrEqualTo(String value) {
            addCriterion("replay_content >=", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentLessThan(String value) {
            addCriterion("replay_content <", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentLessThanOrEqualTo(String value) {
            addCriterion("replay_content <=", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_content <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayContentLike(String value) {
            addCriterion("replay_content like", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentNotLike(String value) {
            addCriterion("replay_content not like", value, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentIn(List<String> values) {
            addCriterion("replay_content in", values, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentNotIn(List<String> values) {
            addCriterion("replay_content not in", values, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentBetween(String value1, String value2) {
            addCriterion("replay_content between", value1, value2, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayContentNotBetween(String value1, String value2) {
            addCriterion("replay_content not between", value1, value2, "replayContent");
            return (Criteria) this;
        }

        public Criteria andReplayAdminIsNull() {
            addCriterion("replay_admin is null");
            return (Criteria) this;
        }

        public Criteria andReplayAdminIsNotNull() {
            addCriterion("replay_admin is not null");
            return (Criteria) this;
        }

        public Criteria andReplayAdminEqualTo(Long value) {
            addCriterion("replay_admin =", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminNotEqualTo(Long value) {
            addCriterion("replay_admin <>", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminGreaterThan(Long value) {
            addCriterion("replay_admin >", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminGreaterThanOrEqualTo(Long value) {
            addCriterion("replay_admin >=", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminLessThan(Long value) {
            addCriterion("replay_admin <", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminLessThanOrEqualTo(Long value) {
            addCriterion("replay_admin <=", value, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_admin <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayAdminIn(List<Long> values) {
            addCriterion("replay_admin in", values, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminNotIn(List<Long> values) {
            addCriterion("replay_admin not in", values, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminBetween(Long value1, Long value2) {
            addCriterion("replay_admin between", value1, value2, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayAdminNotBetween(Long value1, Long value2) {
            addCriterion("replay_admin not between", value1, value2, "replayAdmin");
            return (Criteria) this;
        }

        public Criteria andReplayTimeIsNull() {
            addCriterion("replay_time is null");
            return (Criteria) this;
        }

        public Criteria andReplayTimeIsNotNull() {
            addCriterion("replay_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplayTimeEqualTo(Date value) {
            addCriterion("replay_time =", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeNotEqualTo(Date value) {
            addCriterion("replay_time <>", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeGreaterThan(Date value) {
            addCriterion("replay_time >", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("replay_time >=", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeLessThan(Date value) {
            addCriterion("replay_time <", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeLessThanOrEqualTo(Date value) {
            addCriterion("replay_time <=", value, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeLessThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("replay_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andReplayTimeIn(List<Date> values) {
            addCriterion("replay_time in", values, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeNotIn(List<Date> values) {
            addCriterion("replay_time not in", values, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeBetween(Date value1, Date value2) {
            addCriterion("replay_time between", value1, value2, "replayTime");
            return (Criteria) this;
        }

        public Criteria andReplayTimeNotBetween(Date value1, Date value2) {
            addCriterion("replay_time not between", value1, value2, "replayTime");
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

        public Criteria andCreateTimeEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("create_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("create_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("create_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("create_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanColumn(YxxProductComment.Column column) {
            addCriterion(new StringBuilder("create_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToColumn(YxxProductComment.Column column) {
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
    }

    public static class Criteria extends GeneratedCriteria {
        private YxxProductCommentExample example;

        protected Criteria(YxxProductCommentExample example) {
            super();
            this.example = example;
        }

        public YxxProductCommentExample example() {
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
        void example(com.macro.mall.example.YxxProductCommentExample example);
    }
}