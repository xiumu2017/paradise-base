package com.macro.mall.portal.service;

import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.YxxHomeBanner;
import com.macro.mall.model.YxxProductCommentLabel;
import com.macro.mall.model.YxxRegion;

import java.util.List;

/**
 * 首页内容管理Service
 *
 * @author macro
 * @date 2019/1/28
 */
public interface HomeService {
    /**
     * 查询首页 轮播图
     *
     * @param regionId 区域ID
     * @return 轮播图列表
     */
    List<YxxHomeBanner> homeBannerList(Long regionId);

    /**
     * 获取商品分类
     *
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     * @return {@link com.macro.mall.model.PmsProductCategory}
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 查询区域列表
     *
     * @return {@link YxxRegion}
     */
    List<YxxRegion> getRegionList();

    /**
     * 查询label
     *
     * @return 预设评价列表
     */
    List<YxxProductCommentLabel> getLabelList();
}
