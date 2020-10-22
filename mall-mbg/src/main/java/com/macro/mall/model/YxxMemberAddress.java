package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 垚修修用户服务地址表
 *
 * @author Paradise
 */
@ApiModel(value = "垚修修用户服务地址")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxMemberAddress implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long memberId;

    @ApiModelProperty(value = "收货人名称")
    private String name;

    @ApiModelProperty(value = "性别：1男0女")
    private Integer sex;

    @ApiModelProperty(value = "联系方式")
    private String phoneNumber;

    @ApiModelProperty(value = "是否为默认")
    private Integer defaultStatus;

    @ApiModelProperty(value = "邮政编码", hidden = true)
    private String postCode;

    @ApiModelProperty(value = "省份/直辖市", hidden = true)
    private String province;

    @ApiModelProperty(value = "城市", hidden = true)
    private String city;

    @ApiModelProperty(value = "区", hidden = true)
    private String region;

    @ApiModelProperty(value = "详细地址(街道)")
    private String detailAddress;

    @ApiModelProperty(value = "坐标")
    private String location;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        memberId("member_id", "memberId", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        sex("sex", "sex", "INTEGER", false),
        phoneNumber("phone_number", "phoneNumber", "VARCHAR", false),
        defaultStatus("default_status", "defaultStatus", "INTEGER", false),
        postCode("post_code", "postCode", "VARCHAR", false),
        province("province", "province", "VARCHAR", false),
        city("city", "city", "VARCHAR", false),
        region("region", "region", "VARCHAR", false),
        detailAddress("detail_address", "detailAddress", "VARCHAR", false),
        location("location", "location", "VARCHAR", true),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false);

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

        public static Column[] excludes(Column... excludes) {
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