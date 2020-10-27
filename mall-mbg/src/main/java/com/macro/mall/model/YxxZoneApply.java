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
 * 
 *
 * @author Paradise
 */
@ApiModel(value="")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxZoneApply implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="申请人ID")
    private Long workerId;

    @ApiModelProperty(value="申请人")
    private String workerName;

    @ApiModelProperty(value="地域")
    private Long regionId;

    @ApiModelProperty(value="地域名称")
    private String regionName;

    @ApiModelProperty(value="区域中心ID")
    private Long zoneId;

    @ApiModelProperty(value="申请内容")
    private String applyContent;

    @ApiModelProperty(value="申请时间")
    private Date applyTime;

    @ApiModelProperty(value="申请状态：0申请中1已同意2已拒绝")
    private Integer applyStatus;

    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        workerId("worker_id", "workerId", "BIGINT", false),
        workerName("worker_name", "workerName", "VARCHAR", false),
        regionId("region_id", "regionId", "BIGINT", false),
        regionName("region_name", "regionName", "VARCHAR", false),
        zoneId("zone_id", "zoneId", "BIGINT", false),
        applyContent("apply_content", "applyContent", "VARCHAR", false),
        applyTime("apply_time", "applyTime", "TIMESTAMP", false),
        applyStatus("apply_status", "applyStatus", "INTEGER", false),
        remark("remark", "remark", "VARCHAR", false);

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