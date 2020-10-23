package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 垚修修服务评价表
 *
 * @author Paradise
 */
@ApiModel(value="垚修修服务评价")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxProductComment implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="服务品类ID")
    private Long productId;

    @ApiModelProperty(value="会员ID")
    private Long memberId;

    @ApiModelProperty(value="订单ID")
    private Long orderId;

    @ApiModelProperty(value="规格ID")
    private Long skuId;

    @ApiModelProperty(value="会员姓名")
    private String memberName;

    @ApiModelProperty(value="服务品类名称")
    private String productName;

    @ApiModelProperty(value="规格名称")
    private String skuName;

    @ApiModelProperty(value="评价星数：0->5")
    private Integer star;

    @ApiModelProperty(value="是否展示：1是0否")
    private Integer showStatus;

    @ApiModelProperty(value="收藏数量")
    private Integer collectCount;

    @ApiModelProperty(value="阅读数量")
    private Integer readCount;

    @ApiModelProperty(value="点赞数量")
    private Integer loveCount;

    @ApiModelProperty(value="评价内容")
    private String content;

    @ApiModelProperty(value="上传图片地址，以逗号隔开")
    private String pics;

    @ApiModelProperty(value="评论用户头像")
    private String memberIcon;

    @ApiModelProperty(value="是否回复：1是0否")
    private Integer isReplay;

    @ApiModelProperty(value="回复内容")
    private String replayContent;

    @ApiModelProperty(value="回复管理员")
    private Long replayAdmin;

    @ApiModelProperty(value="回复时间")
    private Date replayTime;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        productId("product_id", "productId", "BIGINT", false),
        memberId("member_id", "memberId", "BIGINT", false),
        orderId("order_id", "orderId", "BIGINT", false),
        skuId("sku_id", "skuId", "BIGINT", false),
        memberName("member_name", "memberName", "VARCHAR", false),
        productName("product_name", "productName", "VARCHAR", false),
        skuName("sku_name", "skuName", "VARCHAR", false),
        star("star", "star", "INTEGER", false),
        showStatus("show_status", "showStatus", "INTEGER", false),
        collectCount("collect_count", "collectCount", "INTEGER", false),
        readCount("read_count", "readCount", "INTEGER", false),
        loveCount("love_count", "loveCount", "INTEGER", false),
        content("content", "content", "VARCHAR", false),
        pics("pics", "pics", "VARCHAR", false),
        memberIcon("member_icon", "memberIcon", "VARCHAR", false),
        isReplay("is_replay", "isReplay", "INTEGER", false),
        replayContent("replay_content", "replayContent", "VARCHAR", false),
        replayAdmin("replay_admin", "replayAdmin", "BIGINT", false),
        replayTime("replay_time", "replayTime", "TIMESTAMP", false),
        createTime("create_time", "createTime", "TIMESTAMP", false);

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