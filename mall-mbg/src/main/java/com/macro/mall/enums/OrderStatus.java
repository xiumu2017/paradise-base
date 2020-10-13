package com.macro.mall.enums;

/**
 * @author Paradise
 */
public enum OrderStatus {

    /**
     * 用户下单 - 待派单
     */
    CREATED(0),

    /**
     * 进入派单队列 - 派单中
     */
    DISTRIBUTING(1),

    /**
     * 已派单 - 待接单 - 生成派单记录
     */
    DISTRIBUTED(2),

    /**
     * 已接单 - 电话确认
     */
    RECEIVED(3),

    /**
     * 待上门
     */
    WAITED_GET(4),

    /**
     * 出发
     */
    SET_OFF(5),

    /**
     * 已到达
     */
    ARRIVED(6),

    /**
     * 已报价
     */
    OFFERED(7),

    /**
     * 到达后取消
     */
    ARRIVED_CANCEL(8),

    /**
     * 用户确认报价
     */
    OFFER_CONFIRMED(9),

    /**
     * 维修中
     */
    REPAIRING(10),

    /**
     * 维修完成 - 待支付
     */
    REPAIRED(11),

    /**
     * 用户已支付
     */
    PAYED(12),

    /**
     * 取消订单
     */
    FREE_CANCEL(13),

    /**
     * 客服介入取消
     */
    CS_CANCEL(14),

    /**
     * 订单暂缓
     */
    PAUSED(15),

    /**
     * 已转单
     */
    TRANSFERRED(16),

    ;

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int val() {
        return value;
    }
}
