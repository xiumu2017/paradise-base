package com.macro.mall.dao;

import com.macro.mall.dto.OmsOrderDetail;
import com.macro.mall.dto.YxxOrderQueryParam;
import com.macro.mall.model.YxxOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 * @author Paradise
 * @date 2020-10-10
 */
public interface YxxOrderDao {
    /**
     * 条件查询订单
     *
     * @param queryParam {@link YxxOrderQueryParam} 查询参数
     * @return {@link YxxOrder}
     */
    List<YxxOrder> getList(@Param("queryParam") YxxOrderQueryParam queryParam);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
