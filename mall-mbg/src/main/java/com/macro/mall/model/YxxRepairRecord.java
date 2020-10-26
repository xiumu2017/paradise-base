package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 垚修修维修记录表
 *
 * @author Paradise
 */
@ApiModel(value="垚修修维修记录")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YxxRepairRecord implements Serializable {
    @ApiModelProperty(value="自增主键")
    private Long id;

    @ApiModelProperty(value="订单ID")
    private Long orderId;

    @ApiModelProperty(value="维修工ID")
    private Long workerId;

    @ApiModelProperty(value="维修前图片")
    private String beforePhotos;

    @ApiModelProperty(value="维修前故障点图片")
    private String beforePhotosDetail;

    @ApiModelProperty(value="维修后图片")
    private String afterPhotos;

    @ApiModelProperty(value="维修后故障点图片")
    private String afterPhotosDetail;

    @ApiModelProperty(value="零件照片")
    private String partsPhotos;

    @ApiModelProperty(value="维修情况备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        orderId("order_id", "orderId", "BIGINT", false),
        workerId("worker_id", "workerId", "BIGINT", false),
        beforePhotos("before_photos", "beforePhotos", "VARCHAR", false),
        beforePhotosDetail("before_photos_detail", "beforePhotosDetail", "VARCHAR", false),
        afterPhotos("after_photos", "afterPhotos", "VARCHAR", false),
        afterPhotosDetail("after_photos_detail", "afterPhotosDetail", "VARCHAR", false),
        partsPhotos("parts_photos", "partsPhotos", "VARCHAR", false),
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