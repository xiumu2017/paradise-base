package com.macro.mall.domain;

import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxRepairRecord;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author Paradise
 */
@ApiModel("垚修修订单详情")
@Data
public class YxxOrderDetail {
    /**
     * 订单信息
     */
    private YxxOrder yxxOrder;
    /**
     * 维修工单
     */
    private YxxRepairRecord repairRecord;
    /**
     * 订单状态变更列表
     */
    private List<YxxOrderStatusRecord> orderStatusRecordList;
}
