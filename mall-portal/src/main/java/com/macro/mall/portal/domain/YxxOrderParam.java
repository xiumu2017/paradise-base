package com.macro.mall.portal.domain;

import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 生成订单时传入的参数
 *
 * @author Paradise
 * @date 2020-10-12
 */
@Data
public class YxxOrderParam {
    @ApiModelProperty("维修地址ID")
    @NotNull(message = "维修地址ID不能为空")
    private Long addressId;

    @ApiModelProperty("优惠券ID")
    private Long couponId;

    @ApiModelProperty("手机号码")
    private String telephone;

    @ApiModelProperty("服务品类ID")
    @NotNull
    private Long productId;

    @ApiModelProperty("服务品类规格ID")
    private Long skuId;

    @ApiModelProperty("上门时间区间起点")
    private Long visitTimeStart;

    @ApiModelProperty("上门时间区间终点")
    private Long visitTimeEnd;

    @ApiModelProperty("订单备注")
    private String remark;

    @ApiModelProperty("照片（多张英文逗号分隔）")
    private String pics;

    @ApiModelProperty("详细地址")
    private String detailAddress;
    /**
     * 子订单信息
     */
    @ApiModelProperty("子订单信息")
    private List<YxxOrderItem> itemList;

    public YxxOrder toOrder() {
        YxxOrder order = new YxxOrder();
        order.setCouponId(couponId);
        order.setPhotos(pics);
        order.setProductId(productId);
        order.setTelNo(telephone);
        order.setSkuId(skuId);
        order.setVisitTimeStart(new Date(visitTimeStart));
        order.setVisitTimeEnd(new Date(visitTimeEnd));
        order.setRemark(remark);
        order.setDetailAddress(detailAddress);
        return order;
    }

}
