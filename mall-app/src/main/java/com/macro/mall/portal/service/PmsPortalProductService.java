package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.PmsProductCategoryNode;
import com.macro.mall.portal.domain.PmsProductNode;

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
     * @return {@link PmsProductCategoryNode}
     */
    List<PmsProductNode> categoryTreeList();

}
