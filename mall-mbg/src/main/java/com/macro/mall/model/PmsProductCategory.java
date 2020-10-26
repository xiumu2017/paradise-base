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
 * 
 *
 * @author Paradise
 */
@ApiModel(value="")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductCategory implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="上机分类的编号：0表示一级分类")
    private Long parentId;

    @ApiModelProperty(value="")
    private String name;

    @ApiModelProperty(value="分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty(value="是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value="显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty(value="")
    private Integer sort;

    @ApiModelProperty(value="图标")
    private String icon;

    @ApiModelProperty(value="")
    private String keywords;

    @ApiModelProperty(value="地域ID")
    private Long regionId;

    @ApiModelProperty(value="地域名称")
    private String regionName;

    @ApiModelProperty(value="描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        parentId("parent_id", "parentId", "BIGINT", false),
        name("name", "name", "VARCHAR", true),
        level("level", "level", "INTEGER", true),
        navStatus("nav_status", "navStatus", "INTEGER", false),
        showStatus("show_status", "showStatus", "INTEGER", false),
        sort("sort", "sort", "INTEGER", false),
        icon("icon", "icon", "VARCHAR", false),
        keywords("keywords", "keywords", "VARCHAR", false),
        regionId("region_id", "regionId", "BIGINT", false),
        regionName("region_name", "regionName", "VARCHAR", false),
        description("description", "description", "LONGVARCHAR", false);

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