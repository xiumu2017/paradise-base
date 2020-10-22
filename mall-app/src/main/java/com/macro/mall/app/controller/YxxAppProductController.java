package com.macro.mall.app.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.app.domain.PmsProductNode;
import com.macro.mall.app.service.PmsPortalProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public CommonResult<List<PmsProductNode>> categoryTreeList() {
        List<PmsProductNode> list = portalProductService.categoryTreeList();
        return CommonResult.success(list);
    }

}
