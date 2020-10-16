package com.macro.mall.portal.domain;

import com.macro.mall.model.YxxWorkerSkilledProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("维修工擅长品类信息")
public class WorkerSkilledProductInfo extends YxxWorkerSkilledProduct {
    /**
     * 服务品类名称
     */
    @ApiModelProperty("服务品类名称")
    private String productName;
}
