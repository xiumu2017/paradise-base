package com.macro.mall.domain;

import com.macro.mall.enums.OrderStatusUtil;
import com.macro.mall.model.YxxOrderStatusRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Paradise
 */
@Data
@ApiModel("垚修修订单状态变更记录信息")
public class YxxOrderStatusRecordInfo {
    @ApiModelProperty(value = "自增主键")
    private Long id;

    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "原状态")
    private Integer originStatus;

    @ApiModelProperty(value = "新状态")
    private Integer currentStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态变更时间")
    private Date createTime;
    /**
     * 原始状态名称
     */
    @ApiModelProperty("原始状态名称")
    private String originStatusName;
    /**
     * 当前状态名称
     */
    @ApiModelProperty("当前状态名称")
    private String currentStatusName;

    public YxxOrderStatusRecordInfo(YxxOrderStatusRecord record) {
        this.id = record.getId();
        this.orderId = record.getOrderId();
        this.originStatus = record.getOriginStatus();
        this.currentStatus = record.getCurrentStatus();
        this.remark = record.getRemark();
        this.createTime = record.getCreateTime();
        this.originStatusName = OrderStatusUtil.getStatusName(record.getOriginStatus());
        this.currentStatusName = OrderStatusUtil.getStatusName(record.getCurrentStatus());
    }
}
