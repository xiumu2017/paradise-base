package com.macro.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sku规格
 *
 * @author Paradise
 */
@ApiModel(value="sku规格")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductSku implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long productId;

    @ApiModelProperty(value="sku编码")
    private String skuCode;

    @ApiModelProperty(value="")
    private BigDecimal price;

    @ApiModelProperty(value="展示图片")
    private String pic;

    @ApiModelProperty(value="销量")
    private Integer sale;

    @ApiModelProperty(value="单品促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value="规格名称")
    private String skuName;

    private static final long serialVersionUID = 1L;

    public enum Column {
        id("id", "id", "BIGINT", false),
        productId("product_id", "productId", "BIGINT", false),
        skuCode("sku_code", "skuCode", "VARCHAR", false),
        price("price", "price", "DECIMAL", false),
        pic("pic", "pic", "VARCHAR", false),
        sale("sale", "sale", "INTEGER", false),
        promotionPrice("promotion_price", "promotionPrice", "DECIMAL", false),
        skuName("sku_name", "skuName", "VARCHAR", false);

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