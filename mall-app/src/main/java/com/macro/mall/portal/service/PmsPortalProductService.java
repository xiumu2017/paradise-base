package com.macro.mall.portal.service;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.PmsPortalProductDetail;
import com.macro.mall.portal.domain.PmsProductCategoryNode;

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
     * @param keyword           关键词
     * @param productCategoryId 分类ID
     * @param pageNum           pageNum
     * @param pageSize          pageSize
     * @return {@link PmsProduct}
     */
    List<PmsProduct> search(String keyword, Long productCategoryId, Integer pageNum, Integer pageSize);

    /**
     * 以树形结构获取所有商品分类
     *
     * @return {@link PmsProductCategoryNode}
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     *
     * @param id 品类ID
     * @return {@link PmsPortalProductDetail}
     */
    PmsPortalProductDetail detail(Long id);
}
