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
 * 垚修修小程序QA配置表
 *
 * @author Paradise
 */
@ApiModel(value="垚修修小程序QA配置")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxHomeQa implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="区域ID")
    private Long regionId;

    @ApiModelProperty(value="是否启用")
    private Integer enable;

    @ApiModelProperty(value="是否删除")
    private Integer deleted;

    @ApiModelProperty(value="问题")
    private String question;

    @ApiModelProperty(value="回答")
    private String answer;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="序号")
    private Integer orderNum;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        regionId("region_id", "regionId", "BIGINT", false),
        enable("enable", "enable", "INTEGER", true),
        deleted("deleted", "deleted", "INTEGER", false),
        question("question", "question", "VARCHAR", false),
        answer("answer", "answer", "VARCHAR", false),
        remark("remark", "remark", "VARCHAR", false),
        orderNum("order_num", "orderNum", "INTEGER", false),
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