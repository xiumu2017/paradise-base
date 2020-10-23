package com.macro.mall.enums;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
public class OrderStatusUtil {
    public static Integer[] getStatusArray(int type) {
        if (type == 1) {
            return new Integer[]{
                    CREATED.val(), DISTRIBUTING.val(), DISTRIBUTED.val(), RECEIVED.val(), WAITED_GET.val(),
                    SET_OFF.val(), ARRIVED.val(), OFFERED.val(), OFFER_CONFIRMED.val(), REPAIRING.val(), REPAIRED.val()
            };
        }

        return new Integer[]{
                PAYED.val(), FREE_CANCEL.val(), CS_CANCEL.val(), ARRIVED_CANCEL.val()
        };
    }
}
