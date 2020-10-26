package com.macro.mall.example;

import com.macro.mall.model.YxxRepairRecord;
import java.util.ArrayList;
import java.util.List;

public class YxxRepairRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxxRepairRecordExample() {
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

    public YxxRepairRecordExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public YxxRepairRecordExample orderBy(String ... orderByClauses) {
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
        YxxRepairRecordExample example = new YxxRepairRecordExample();
        return example.createCriteria();
    }

    public YxxRepairRecordExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public YxxRepairRecordExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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

        public Criteria andIdEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
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

        public Criteria andOrderIdEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("order_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("order_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("order_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("order_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("order_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
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

        public Criteria andWorkerIdEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("worker_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(Long value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("worker_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(Long value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("worker_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("worker_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(Long value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("worker_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
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

        public Criteria andBeforePhotosIsNull() {
            addCriterion("before_photos is null");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosIsNotNull() {
            addCriterion("before_photos is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosEqualTo(String value) {
            addCriterion("before_photos =", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosNotEqualTo(String value) {
            addCriterion("before_photos <>", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosGreaterThan(String value) {
            addCriterion("before_photos >", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosGreaterThanOrEqualTo(String value) {
            addCriterion("before_photos >=", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosLessThan(String value) {
            addCriterion("before_photos <", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosLessThanOrEqualTo(String value) {
            addCriterion("before_photos <=", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosLike(String value) {
            addCriterion("before_photos like", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosNotLike(String value) {
            addCriterion("before_photos not like", value, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosIn(List<String> values) {
            addCriterion("before_photos in", values, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosNotIn(List<String> values) {
            addCriterion("before_photos not in", values, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosBetween(String value1, String value2) {
            addCriterion("before_photos between", value1, value2, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosNotBetween(String value1, String value2) {
            addCriterion("before_photos not between", value1, value2, "beforePhotos");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailIsNull() {
            addCriterion("before_photos_detail is null");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailIsNotNull() {
            addCriterion("before_photos_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailEqualTo(String value) {
            addCriterion("before_photos_detail =", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailNotEqualTo(String value) {
            addCriterion("before_photos_detail <>", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailGreaterThan(String value) {
            addCriterion("before_photos_detail >", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailGreaterThanOrEqualTo(String value) {
            addCriterion("before_photos_detail >=", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailLessThan(String value) {
            addCriterion("before_photos_detail <", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailLessThanOrEqualTo(String value) {
            addCriterion("before_photos_detail <=", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("before_photos_detail <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailLike(String value) {
            addCriterion("before_photos_detail like", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailNotLike(String value) {
            addCriterion("before_photos_detail not like", value, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailIn(List<String> values) {
            addCriterion("before_photos_detail in", values, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailNotIn(List<String> values) {
            addCriterion("before_photos_detail not in", values, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailBetween(String value1, String value2) {
            addCriterion("before_photos_detail between", value1, value2, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andBeforePhotosDetailNotBetween(String value1, String value2) {
            addCriterion("before_photos_detail not between", value1, value2, "beforePhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosIsNull() {
            addCriterion("after_photos is null");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosIsNotNull() {
            addCriterion("after_photos is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosEqualTo(String value) {
            addCriterion("after_photos =", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosNotEqualTo(String value) {
            addCriterion("after_photos <>", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosGreaterThan(String value) {
            addCriterion("after_photos >", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosGreaterThanOrEqualTo(String value) {
            addCriterion("after_photos >=", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosLessThan(String value) {
            addCriterion("after_photos <", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosLessThanOrEqualTo(String value) {
            addCriterion("after_photos <=", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosLike(String value) {
            addCriterion("after_photos like", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosNotLike(String value) {
            addCriterion("after_photos not like", value, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosIn(List<String> values) {
            addCriterion("after_photos in", values, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosNotIn(List<String> values) {
            addCriterion("after_photos not in", values, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosBetween(String value1, String value2) {
            addCriterion("after_photos between", value1, value2, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosNotBetween(String value1, String value2) {
            addCriterion("after_photos not between", value1, value2, "afterPhotos");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailIsNull() {
            addCriterion("after_photos_detail is null");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailIsNotNull() {
            addCriterion("after_photos_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailEqualTo(String value) {
            addCriterion("after_photos_detail =", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailNotEqualTo(String value) {
            addCriterion("after_photos_detail <>", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailGreaterThan(String value) {
            addCriterion("after_photos_detail >", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailGreaterThanOrEqualTo(String value) {
            addCriterion("after_photos_detail >=", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailLessThan(String value) {
            addCriterion("after_photos_detail <", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailLessThanOrEqualTo(String value) {
            addCriterion("after_photos_detail <=", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("after_photos_detail <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailLike(String value) {
            addCriterion("after_photos_detail like", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailNotLike(String value) {
            addCriterion("after_photos_detail not like", value, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailIn(List<String> values) {
            addCriterion("after_photos_detail in", values, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailNotIn(List<String> values) {
            addCriterion("after_photos_detail not in", values, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailBetween(String value1, String value2) {
            addCriterion("after_photos_detail between", value1, value2, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andAfterPhotosDetailNotBetween(String value1, String value2) {
            addCriterion("after_photos_detail not between", value1, value2, "afterPhotosDetail");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosIsNull() {
            addCriterion("parts_photos is null");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosIsNotNull() {
            addCriterion("parts_photos is not null");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosEqualTo(String value) {
            addCriterion("parts_photos =", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosNotEqualTo(String value) {
            addCriterion("parts_photos <>", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosGreaterThan(String value) {
            addCriterion("parts_photos >", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosGreaterThanOrEqualTo(String value) {
            addCriterion("parts_photos >=", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosLessThan(String value) {
            addCriterion("parts_photos <", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosLessThanOrEqualTo(String value) {
            addCriterion("parts_photos <=", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("parts_photos <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPartsPhotosLike(String value) {
            addCriterion("parts_photos like", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosNotLike(String value) {
            addCriterion("parts_photos not like", value, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosIn(List<String> values) {
            addCriterion("parts_photos in", values, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosNotIn(List<String> values) {
            addCriterion("parts_photos not in", values, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosBetween(String value1, String value2) {
            addCriterion("parts_photos between", value1, value2, "partsPhotos");
            return (Criteria) this;
        }

        public Criteria andPartsPhotosNotBetween(String value1, String value2) {
            addCriterion("parts_photos not between", value1, value2, "partsPhotos");
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

        public Criteria andRemarkEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualToColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanColumn(YxxRepairRecord.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualToColumn(YxxRepairRecord.Column column) {
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
    }

    public static class Criteria extends GeneratedCriteria {
        private YxxRepairRecordExample example;

        protected Criteria(YxxRepairRecordExample example) {
            super();
            this.example = example;
        }

        public YxxRepairRecordExample example() {
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
        void example(com.macro.mall.example.YxxRepairRecordExample example);
    }
}