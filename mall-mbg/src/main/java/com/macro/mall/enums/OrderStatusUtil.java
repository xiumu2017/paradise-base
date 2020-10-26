package com.macro.mall.enums;

import java.util.HashMap;
import java.util.Map;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
public class OrderStatusUtil {
    public static Integer[] getStatusArray(int type) {
        if (type == 1) {
            return new Integer[]{
                    RECEIVED.val(), WAITED_GET.val(), SET_OFF.val(), ARRIVED.val(), OFFERED.val(),
                    OFFER_CONFIRMED.val(), REPAIRING.val(), REPAIRED.val()
            };
        }

        return new Integer[]{
                PAYED.val(), FREE_CANCEL.val(), CS_CANCEL.val(), ARRIVED_CANCEL.val()
        };
    }

    private static Map<Integer, String> statusNameMap = new HashMap<>();

    static {
        statusNameMap.put(CREATED.val(), "待派单");
        statusNameMap.put(DISTRIBUTING.val(), "派单中");
        statusNameMap.put(DISTRIBUTED.val(), "待接单");
        statusNameMap.put(RECEIVED.val(), "已接单");
        statusNameMap.put(WAITED_GET.val(), "待上门");
        statusNameMap.put(SET_OFF.val(), "已出发");
        statusNameMap.put(ARRIVED.val(), "已到达");
        statusNameMap.put(OFFERED.val(), "已报价");
        statusNameMap.put(OFFER_CONFIRMED.val(), "已确认报价");
        statusNameMap.put(REPAIRING.val(), "维修中");
        statusNameMap.put(REPAIRED.val(), "已维修");
        statusNameMap.put(PAYED.val(), "已支付");
        statusNameMap.put(COMPLETED.val(), "已完成");
        statusNameMap.put(FREE_CANCEL.val(), "已取消");
        statusNameMap.put(ARRIVED_CANCEL.val(), "到达后取消");
        statusNameMap.put(CS_CANCEL.val(), "客服取消");
        statusNameMap.put(PAUSED.val(), "订单暂缓");
        statusNameMap.put(TRANSFERRED.val(), "已转单");
        statusNameMap.put(WAIT_MANUAL.val(), "等待手动指派");
    }

    public static String getStatusName(Integer val) {
        return statusNameMap.get(val);
    }
}
