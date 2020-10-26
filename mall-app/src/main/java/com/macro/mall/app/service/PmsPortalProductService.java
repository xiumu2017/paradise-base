package com.macro.mall.app.service;

import com.macro.mall.app.domain.PmsProductCategoryNode;
import com.macro.mall.app.domain.PmsProductNode;
import com.macro.mall.model.PmsProduct;

import java.util.List;

/**
 * 前台商品管理Service
 *
 * @author macro
 * @date 2020/4/6
 */
public interface PmsPortalProductService {

    /**
     * 以树形结构获取所有商品分类
     *
     * @param regionId 区域ID
     * @return {@link PmsProductCategoryNode}
     */
    List<PmsProductNode> categoryTreeList(Long regionId);

    /**
     * 查询服务品类详情
     *
     * @param id 主键
     * @return {@link PmsProduct}
     */
    PmsProduct productInfo(Long id);

    /**
     * 列表查询服务品类
     *
     * @param regionId 地域ID
     * @return 列表
     */
    List<PmsProduct> productInfoList(Long regionId);
}
