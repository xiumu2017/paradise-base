package com.macro.mall.common.constant;

/**
 * 订单类型枚举
 *
 * @author Paradise
 */
public enum OrderType {
    /**
     * default
     */
    NULL,
    SYSTEM_DISTRIBUTE,
    SYSTEM_RUSH,
    MANUAL_DISTRIBUTE,
    ZONE_DISTRIBUTE;

    public int val() {
        return ordinal();
    }

}
