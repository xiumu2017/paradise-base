package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 添加更新产品分类的参数
 *
 * @author macro
 * @date 2018/4/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @ApiModelProperty("父分类的编号")
    private Long parentId;

    @ApiModelProperty(value = "商品分类名称", required = true)
    @NotEmpty(message = "服务分类名称不能为空")
    @Length(max = 10, min = 2, message = "服务分类名称字符长度2-10")
    private String name;

    @ApiModelProperty("是否进行显示")
    @FlagValidator(value = {"0", "1"}, message = "状态只能为0或1")
    private Integer showStatus;

    @ApiModelProperty("排序")
    @Min(value = 0, message = "排序最小为0")
    private Integer sort;

    @ApiModelProperty(value = "图标", hidden = true)
    private String icon;

    @ApiModelProperty(value = "关键字", hidden = true)
    private String keywords;

    @ApiModelProperty("描述")
    private String description;

}
