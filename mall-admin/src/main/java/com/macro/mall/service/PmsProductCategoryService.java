package com.macro.mall.service;

import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类Service
 *
 * @author macro
 * @date 2018/4/26
 */
public interface PmsProductCategoryService {
    /**
     * 创建商品分类
     *
     * @param pmsProductCategoryParam {@link PmsProductCategoryParam}
     * @return int
     */
    @Transactional(rollbackFor = Exception.class)
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 修改商品分类
     *
     * @param id                      分类主键
     * @param pmsProductCategoryParam {@link PmsProductCategoryParam}
     * @return int
     */
    @Transactional(rollbackFor = Exception.class)
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 分页获取商品分类
     *
     * @param parentId 父级分类ID
     * @param pageSize pageSize
     * @param pageNum  pageNum
     * @return {@link PmsProductCategory}
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 删除商品分类 （物理删除）
     *
     * @param id 分类ID
     * @return int
     */
    int delete(Long id);

    /**
     * 根据ID获取商品分类
     *
     * @param id 分类主键
     * @return {@link PmsProductCategory}
     */
    PmsProductCategory getItem(Long id);

    /**
     * 批量修改导航状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 以层级形式获取商品分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    /**
     * 分页查询
     *
     * @param parentId 父类ID
     * @param pageSize pageSize
     * @param pageNum  pageNum
     * @param keywords 名称
     * @return 分页查询结果
     */
    List<PmsProductCategoryWithChildrenItem> select4Page(Long parentId, Integer pageSize, Integer pageNum, String keywords);
}
