package com.macro.mall.portal.service;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.PmsProductCategoryNode;
import com.macro.mall.portal.domain.PmsProductDetail;
import com.macro.mall.domain.PmsProductInfo;

import java.util.List;

/**
 * 前台商品管理Service
 *
 * @author macro
 * @date 2020/4/6
 */
public interface PmsPortalProductService {

    /**
     * 综合搜索商品
     *
     * @param keyword           服务品类名称
     * @param productCategoryId 分类名称
     * @param pageNum           分页参数
     * @param pageSize          分页参数
     * @return 品类列表
     */
    List<PmsProduct> search(String keyword, Long productCategoryId, Integer pageNum, Integer pageSize);

    /**
     * 以树形结构获取所有商品分类
     *
     * @param regionId 区域ID
     * @return 分类树形节点
     */
    List<PmsProductCategoryNode> categoryTreeList(Long regionId);

    /**
     * 获取前台商品详情
     *
     * @param id 服务品类ID
     * @return {@link PmsProductDetail}
     */
    PmsProductDetail detail(Long id);

    /**
     * 推荐商品列表
     *
     * @param regionId 区域ID
     * @return 商品列表
     */
    List<PmsProductInfo> recommendProductList(Long regionId);
}
