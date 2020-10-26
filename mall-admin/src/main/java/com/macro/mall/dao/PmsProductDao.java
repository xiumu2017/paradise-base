package com.macro.mall.dao;

import com.macro.mall.domain.PmsProductInfo;
import com.macro.mall.dto.PmsProductQueryParam;

import java.util.List;

/**
 * 服务品类Dao
 *
 * @author Paradise
 */
public interface PmsProductDao {
    /**
     * 获取商品属性信息
     *
     * @param param 查询参数
     * @return {@link PmsProductInfo}
     */
    List<PmsProductInfo> getPmsProductInfoList(PmsProductQueryParam param);
}
