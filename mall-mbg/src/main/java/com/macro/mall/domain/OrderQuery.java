package com.macro.mall.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单查询参数
 *
 * @author Paradise
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单查询参数")
public class OrderQuery {

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "手机号码")
    private String telNo;

    @ApiModelProperty(value = "会员姓名")
    private String memberName;

    @ApiModelProperty(value = "会员性别：0->女 1-> 男")
    private Integer memberSex;

    @ApiModelProperty(value = "服务品类ID")
    private Long productId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "分配维修工ID")
    private Long workerId;

    @ApiModelProperty(value = "是否询价：0->否 1->是")
    private Integer isBargain;

    @ApiModelProperty(value = "是否转单：0->否 1->是")
    private Integer isTransfer;

    @ApiModelProperty(value = "订单创建时间")
    private Date startTime;
    @ApiModelProperty(value = "订单创建时间")
    private Date endTime;

    @ApiModelProperty(value = "服务中心ID")
    private Long zoneId;

    @ApiModelProperty(value = "区域ID")
    private Long regionId;

    @ApiModelProperty(value = "订单类型（1-系统派单2-抢单3-人工指派4-区域分派）")
    private Integer orderType;

    @ApiModelProperty(value = "状态范围", hidden = true)
    private Integer[] array;
}
