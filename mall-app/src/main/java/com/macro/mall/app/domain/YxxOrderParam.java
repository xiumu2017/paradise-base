package com.macro.mall.app.domain;

import com.macro.mall.model.YxxOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 生成订单时传入的参数
 *
 * @author Paradise
 * @date 2020-10-12
 */
@Data
public class YxxOrderParam {
    @ApiModelProperty("维修地址ID")
    private Long addressId;

    @ApiModelProperty("维修地址")
    private String address;

    @ApiModelProperty("维修地址坐标-经纬度")
    private String location;

    @ApiModelProperty("优惠券ID")
    private Long couponId;

    @ApiModelProperty("手机号码")
    private String telephone;

    @ApiModelProperty("服务品类ID")
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

    @ApiModelProperty("性别：1男0女")
    private Integer sex;

    public YxxOrder toOrder() {
        YxxOrder order = new YxxOrder();
        order.setAddress(address);
        order.setCouponId(couponId);
        order.setPhotos(pics);
        order.setProductId(productId);
        order.setTelNo(telephone);
        order.setSkuId(skuId);
        order.setVisitTimeStart(new Date(visitTimeStart));
        order.setVisitTimeEnd(new Date(visitTimeEnd));
        order.setRemark(remark);
        order.setMemberSex(sex);
        return order;
    }

}
