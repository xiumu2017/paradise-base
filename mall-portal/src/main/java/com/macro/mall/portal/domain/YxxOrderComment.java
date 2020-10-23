package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 垚修修服务评价
 *
 * @author Paradise
 */
@Data
@ApiModel(value = "垚修修服务评价")
public class YxxOrderComment {


    @ApiModelProperty(value = "评价星数：0->5")
    private Integer star;


    @ApiModelProperty(value = "评价内容")
    private String content;


    @ApiModelProperty(value = "上传图片地址，以逗号隔开")
    private String pics;

    @ApiModelProperty(value = "评价标签，多个逗号分隔")
    private String labels;
}
