package com.macro.mall.app.service.impl;

import com.macro.mall.app.domain.PmsProductNode;
import com.macro.mall.app.service.PmsPortalProductService;
import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.example.PmsProductExample;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台订单管理Service实现类
 *
 * @author macro
 * @date 2020/4/6
 */
@Service
@AllArgsConstructor
public class PmsPortalProductServiceImpl implements PmsPortalProductService {
    private final PmsProductMapper productMapper;
    private final PmsProductCategoryMapper productCategoryMapper;

    @Override
    public List<PmsProductNode> categoryTreeList(Long regionId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        PmsProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdNotEqualTo(0L);
        if (regionId != null) {
            criteria.andRegionIdEqualTo(regionId);
        }
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(example);
        List<PmsProductNode> nodeList = new ArrayList<>();
        allList.forEach(pmsProductCategory -> {
            List<PmsProduct> products = productMapper.selectByExampleSelective(new PmsProductExample().createCriteria()
                    .andProductCategoryIdEqualTo(pmsProductCategory.getId()).example(), PmsProduct.Column.name, PmsProduct.Column.id);
            PmsProductNode node = new PmsProductNode(products);
            node.setName(pmsProductCategory.getName());
            node.setId(pmsProductCategory.getId());
            nodeList.add(node);
        });
        return nodeList;
    }

    @Override
    public PmsProduct productInfo(Long id) {

        return productMapper.selectByPrimaryKeySelective(id, PmsProduct.Column.excludes(
                PmsProduct.Column.detailHtml
        ));
    }

    @Override
    public List<PmsProduct> productInfoList(Long regionId) {
        return productMapper.selectByExampleSelective(new PmsProductExample().createCriteria().andDeleteStatusNotEqualTo(1)
                        .when(regionId != null, criteria -> criteria.andRegionIdEqualTo(regionId)).example().orderBy(PmsProduct.Column.sort.desc()),
                PmsProduct.Column.excludes(
                        PmsProduct.Column.detailHtml
                ));
    }
}
