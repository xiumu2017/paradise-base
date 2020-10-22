package com.macro.mall.app.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品分类，包含子分类
 *
 * @author macro
 * @date 2020/4/6
 */
@Getter
@Setter
public class PmsProductNode extends PmsProductCategory {
    private List<PmsProduct> children;

    public PmsProductNode(List<PmsProduct> children) {
        this.children = children;
    }
}
