package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.PmsProductCategoryNode;
import com.macro.mall.portal.domain.PmsProductDetail;
import com.macro.mall.domain.PmsProductInfo;
import com.macro.mall.portal.service.PmsPortalProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台服务品类Controller - 免登陆获取
 *
 * @author macro
 * @date 2020/4/6
 */
@Api(tags = "3.服务品类相关")
@RestController
@RequestMapping("/product")
public class PmsPortalProductController {

    private final PmsPortalProductService portalProductService;

    public PmsPortalProductController(PmsPortalProductService portalProductService) {
        this.portalProductService = portalProductService;
    }

    @ApiOperation(value = "服务品类检索")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProduct>> search(@RequestParam(required = false) String keyword,
                                                       @RequestParam(required = false) Long productCategoryId,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        List<PmsProduct> productList = portalProductService.search(keyword, productCategoryId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("查询小程序首页推荐商品列表")
    @GetMapping("/recommend/list")
    public CommonResult<List<PmsProductInfo>> recommendProductList(@RequestParam(required = false) Long regionId) {
        return CommonResult.success(portalProductService.recommendProductList(regionId));
    }


    @ApiOperation("以树形结构获取所有服务分类")
    @RequestMapping(value = "/categoryTreeList", method = RequestMethod.GET)
    public CommonResult<List<PmsProductCategoryNode>> categoryTreeList(@RequestParam(required = false) Long regionId) {
        List<PmsProductCategoryNode> list = portalProductService.categoryTreeList(regionId);
        return CommonResult.success(list);
    }

    @ApiOperation("获取服务品类详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductDetail> detail(@PathVariable Long id) {
        PmsProductDetail productDetail = portalProductService.detail(id);
        return CommonResult.success(productDetail);
    }


}
