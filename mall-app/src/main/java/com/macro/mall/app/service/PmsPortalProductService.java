package com.macro.mall.app.service;

import com.macro.mall.app.domain.PmsProductCategoryNode;
import com.macro.mall.app.domain.PmsProductNode;

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
