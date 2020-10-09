package com.macro.mall.dto;

import com.macro.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品分类信息 - 包含子分类
 *
 * @author macro
 * @date 2018/5/25
 */
@Getter
@Setter
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
    @ApiModelProperty("父级分类名称")
    private String parentCategoryName;
}
