package com.macro.mall.portal.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.model.SmsCoupon;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 前台商品详情
 *
 * @author macro
 * @date 2020/4/6
 */
@Getter
@Setter
public class PmsProductDetail {
    @ApiModelProperty("品类信息")
    private PmsProduct product;
    @ApiModelProperty("规格信息")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("可用优惠券")
    private List<SmsCoupon> couponList;
}
