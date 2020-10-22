package com.macro.mall.portal.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductSku;
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
public class PmsPortalProductDetail {
    @ApiModelProperty("商品信息")
    private PmsProduct product;
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsProductSku> skuStockList;
    @ApiModelProperty("商品可用优惠券")
    private List<SmsCoupon> couponList;
}
