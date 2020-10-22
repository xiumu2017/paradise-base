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
    public List<PmsProductNode> categoryTreeList() {
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(new PmsProductCategoryExample().createCriteria().andParentIdNotEqualTo(0L).example());
        List<PmsProductNode> nodeList = new ArrayList<>();
        allList.forEach(pmsProductCategory -> {
            List<PmsProduct> products = productMapper.selectByExampleSelective(new PmsProductExample().createCriteria()
                    .andProductCategoryIdEqualTo(pmsProductCategory.getId()).example(), PmsProduct.Column.name);
            PmsProductNode node = new PmsProductNode(products);
            node.setName(pmsProductCategory.getName());
            node.setId(pmsProductCategory.getId());
            nodeList.add(node);
        });
        return nodeList;
    }
}
