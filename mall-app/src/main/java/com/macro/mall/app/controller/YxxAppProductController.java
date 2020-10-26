package com.macro.mall.app.controller;

import com.macro.mall.app.domain.PmsProductNode;
import com.macro.mall.app.service.PmsPortalProductService;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务品类相关
 *
 * @author macro
 * @date 2020/4/6
 */
@RestController
@Api(tags = "3.服务品类相关")
@RequestMapping("/product")
public class YxxAppProductController {

    private final PmsPortalProductService portalProductService;

    public YxxAppProductController(PmsPortalProductService portalProductService) {
        this.portalProductService = portalProductService;
    }

    @ApiOperation("以树形结构获取所有服务品类")
    @RequestMapping(value = "/categoryTreeList", method = RequestMethod.GET)
    public CommonResult<List<PmsProductNode>> categoryTreeList(@RequestParam(required = false) Long regionId) {
        List<PmsProductNode> list = portalProductService.categoryTreeList(regionId);
        return CommonResult.success(list);
    }

    @ApiOperation("查询服务品类详情")
    @GetMapping("/info/{id}")
    public CommonResult<PmsProduct> productInfo(@PathVariable Long id) {
        return CommonResult.success(portalProductService.productInfo(id));
    }

    @ApiOperation("查询全部服务品类信息")
    @GetMapping("/all")
    public CommonResult<List<PmsProduct>> all(@RequestParam(required = false) Long regionId) {
        return CommonResult.success(portalProductService.productInfoList(regionId));
    }

}
