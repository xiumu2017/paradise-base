package com.macro.mall.domain;

import com.macro.mall.model.YxxOrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("子订单信息")
@Data
public class OrderItemInfo extends YxxOrderItem {
    /**
     * 服务品类规格名称
     */
    @ApiModelProperty("服务品类规格名称")
    private String skuName;
}
