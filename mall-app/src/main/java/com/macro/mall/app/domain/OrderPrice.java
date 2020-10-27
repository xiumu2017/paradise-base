package com.macro.mall.app.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Paradise
 */
@ApiModel("订单报价单信息")
@Data
public class OrderPrice {
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("订单报价")
    private BigDecimal price;
    @ApiModelProperty("报价单JSON")
    private String priceJson;
}
