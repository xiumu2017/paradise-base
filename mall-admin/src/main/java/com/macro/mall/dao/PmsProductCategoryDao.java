package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类自定义Dao
 *
 * @author macro
 * @date 2018/5/25
 */
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类及其子分类
     *
     * @return {@link PmsProductCategoryWithChildrenItem} 商品分类包含子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    /**
     * 分页查询
     *
     * @param parentId 父级品类ID
     * @param name     搜索条件 - 名称
     * @param regionId 区域ID
     * @return {@link PmsProductCategoryWithChildrenItem} 商品分类包含子分类
     */
    List<PmsProductCategoryWithChildrenItem> select4Page(@Param("parentId") Long parentId, @Param("name") String name, @Param("regionId") Long regionId);
}
