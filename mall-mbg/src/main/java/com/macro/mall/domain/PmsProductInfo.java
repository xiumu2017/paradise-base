package com.macro.mall.domain;

import com.macro.mall.model.PmsProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("商品信息")
public class PmsProductInfo extends PmsProduct {
    /**
     * 二级服务分类名称
     */
    @ApiModelProperty("二级服务分类名称")
    private String categoryName;
    /**
     * 一级服务分类名称
     */
    @ApiModelProperty("一级服务分类名称")
    private String parentCategoryName;
    /**
     * 一级服务分类ID
     */
    @ApiModelProperty("一级服务分类ID")
    private String parentCategoryId;
}
