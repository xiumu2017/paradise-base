package com.macro.mall.dao;

import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 * @author Paradise
 * @date 2020-10-10
 */
public interface YxxOrderCommonDao {

    /**
     * 查询订单列表
     *
     * @param memberId 会员ID
     * @param array    状态数组
     * @return 订单信息
     */
    List<YxxOrderInfo> queryList(@Param("memberId") Long memberId, @Param("array") Integer[] array);

    /**
     * 查询
     *
     * @param query 查询参数
     * @return 订单列表
     */
    List<YxxOrderInfo> queryListByOrderQuery(@Param("query") OrderQuery query);

    /**
     * 查询订单信息
     *
     * @param id 订单id
     * @return 订单信息
     */
    YxxOrderInfo queryInfoById(@Param("id") Long id);
}
