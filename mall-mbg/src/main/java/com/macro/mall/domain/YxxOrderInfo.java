package com.macro.mall.domain;

import com.macro.mall.model.YxxOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("订单信息")
public class YxxOrderInfo extends YxxOrder {
    /**
     * 服务品类名称
     */
    @ApiModelProperty("服务品类名称")
    private String productName;
    /**
     * 服务品类规格名称
     */
    @ApiModelProperty("服务品类规格名称")
    private String skuName;
    /**
     * 维修工姓名
     */
    @ApiModelProperty("维修工姓名")
    private String workerName;

    @ApiModelProperty("区域")
    private String region;
}
