package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.PmsProductCategoryDao;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.example.PmsProductExample;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.YxxRegionMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.service.PmsProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsProductCategoryService实现类
 *
 * @author macro
 * @date 2018/4/26
 */
@Service
@AllArgsConstructor
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    private final PmsProductCategoryMapper productCategoryMapper;
    private final PmsProductMapper productMapper;
    private final PmsProductCategoryDao productCategoryDao;
    private final YxxRegionMapper regionMapper;

    @Override
    public int create(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        // level 赋值处理
        setCategoryLevel(productCategory);
        if (productCategory.getRegionId() != null) {
            productCategory.setRegionName(regionMapper.selectByPrimaryKey(productCategory.getRegionId()).getRegionName());
        }
        return productCategoryMapper.insertSelective(productCategory);
    }

    @Override
    public int update(Long id, PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        if (productCategory.getRegionId() != null) {
            productCategory.setRegionName(regionMapper.selectByPrimaryKey(productCategory.getRegionId()).getRegionName());
        }
        //更新商品分类时要更新商品中的名称
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(productCategory.getName());
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andProductCategoryIdEqualTo(id);
        productMapper.updateByExampleSelective(product, example);
        return productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum, Long regionId) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        PmsProductCategoryExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(PmsProductCategory.Column.sort.desc());
        criteria.andParentIdEqualTo(parentId);
        criteria.when(regionId != null, criteria1 -> criteria1.andRegionIdEqualTo(regionId));
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> select4Page(Long parentId, Integer pageSize, Integer pageNum, String keywords, Long regionId) {
        PageHelper.startPage(pageNum, pageSize);
        return productCategoryDao.select4Page(parentId, keywords, regionId);
    }

    @Override
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(PmsProductCategory productCategory) {
        //没有父分类时为一级分类
        if (null == productCategory.getParentId() || productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }
}
