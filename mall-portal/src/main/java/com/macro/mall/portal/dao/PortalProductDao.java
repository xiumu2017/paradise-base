package com.macro.mall.portal.dao;

import com.macro.mall.model.SmsCoupon;
import com.macro.mall.portal.domain.PmsProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 *
 * @author macro
 * @date 2018/8/2
 */
public interface PortalProductDao {

    /**
     * 获取可用优惠券列表
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId") Long productCategoryId);

    /**
     * 小程序首页推荐品类列表
     *
     * @param regionId 区域ID
     * @return 品类列表
     */
    List<PmsProductInfo> recommendProductList(@Param("regionId") Long regionId);
}
