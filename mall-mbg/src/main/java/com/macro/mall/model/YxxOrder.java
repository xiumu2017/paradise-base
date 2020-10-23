package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 垚修修订单表
 *
 * @author Paradise
 */
@ApiModel(value="垚修修订单")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxOrder implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="订单号")
    private String orderSn;

    @ApiModelProperty(value="会员ID")
    private Long memberId;

    @ApiModelProperty(value="手机号码")
    private String telNo;

    @ApiModelProperty(value="会员姓名")
    private String memberName;

    @ApiModelProperty(value="会员性别：0->女 1-> 男")
    private Integer memberSex;

    @ApiModelProperty(value="服务品类ID")
    private Long productId;

    @ApiModelProperty(value="服务品类SKU_ID")
    private Long skuId;

    @ApiModelProperty(value="订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value="分配维修工ID")
    private Long workerId;

    @ApiModelProperty(value="订单坐标")
    private String location;

    @ApiModelProperty(value="地址")
    private String address;

    @ApiModelProperty(value="详细地址")
    private String detailAddress;

    @ApiModelProperty(value="上门时间-起点")
    private Date visitTimeStart;

    @ApiModelProperty(value="上门时间-终点")
    private Date visitTimeEnd;

    @ApiModelProperty(value="订单备注")
    private String remark;

    @ApiModelProperty(value="会员下单图片（多张图片逗号分隔）")
    private String photos;

    @ApiModelProperty(value="优惠券ID")
    private Long couponId;

    @ApiModelProperty(value="是否询价：0->否 1->是")
    private Integer isBargain;

    @ApiModelProperty(value="是否转单：0->否 1->是")
    private Integer isTransfer;

    @ApiModelProperty(value="订单取消原因")
    private String cancelReason;

    @ApiModelProperty(value="订单暂缓原因")
    private String pauseReason;

    @ApiModelProperty(value="初始报价")
    private BigDecimal offerPrice;

    @ApiModelProperty(value="抵扣金额")
    private BigDecimal discountPrice;

    @ApiModelProperty(value="实际支付价格")
    private BigDecimal payPrice;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    @ApiModelProperty(value="服务中心ID")
    private Long zoneId;

    @ApiModelProperty(value="区域ID")
    private Long regionId;

    @ApiModelProperty(value="订单类型（1-系统派单2-抢单3-人工指派4-区域分派）")
    private Integer orderType;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        orderSn("order_sn", "orderSn", "VARCHAR", false),
        memberId("member_id", "memberId", "BIGINT", false),
        telNo("tel_no", "telNo", "VARCHAR", false),
        memberName("member_name", "memberName", "VARCHAR", false),
        memberSex("member_sex", "memberSex", "INTEGER", false),
        productId("product_id", "productId", "BIGINT", false),
        skuId("sku_id", "skuId", "BIGINT", false),
        orderStatus("order_status", "orderStatus", "INTEGER", false),
        workerId("worker_id", "workerId", "BIGINT", false),
        location("location", "location", "VARCHAR", true),
        address("address", "address", "VARCHAR", false),
        detailAddress("detail_address", "detailAddress", "VARCHAR", false),
        visitTimeStart("visit_time_start", "visitTimeStart", "TIMESTAMP", false),
        visitTimeEnd("visit_time_end", "visitTimeEnd", "TIMESTAMP", false),
        remark("remark", "remark", "VARCHAR", false),
        photos("photos", "photos", "VARCHAR", false),
        couponId("coupon_id", "couponId", "BIGINT", false),
        isBargain("is_bargain", "isBargain", "INTEGER", false),
        isTransfer("is_transfer", "isTransfer", "INTEGER", false),
        cancelReason("cancel_reason", "cancelReason", "VARCHAR", false),
        pauseReason("pause_reason", "pauseReason", "VARCHAR", false),
        offerPrice("offer_price", "offerPrice", "DECIMAL", false),
        discountPrice("discount_price", "discountPrice", "DECIMAL", false),
        payPrice("pay_price", "payPrice", "DECIMAL", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        zoneId("zone_id", "zoneId", "BIGINT", false),
        regionId("region_id", "regionId", "BIGINT", false),
        orderType("order_type", "orderType", "INTEGER", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}