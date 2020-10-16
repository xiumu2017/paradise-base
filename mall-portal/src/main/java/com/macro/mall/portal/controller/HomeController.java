package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.YxxHomeBanner;
import com.macro.mall.model.YxxRegion;
import com.macro.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页内容管理Controller - 免登陆获取
 *
 * @author macro
 * @date 2019/1/28
 */
@RestController
@Api(tags = "2.首页内容相关")
@RequestMapping("/home")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @ApiOperation("首页-Banner头图列表")
    @RequestMapping(value = "/banner/{regionId}", method = RequestMethod.GET)
    public CommonResult<List<YxxHomeBanner>> content(@PathVariable Long regionId) {
        return CommonResult.success(homeService.homeBannerList(regionId));
    }

    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation("获取区域列表")
    @GetMapping("/region/list")
    public CommonResult<List<YxxRegion>> regionList() {
        return CommonResult.success(homeService.getRegionList());
    }

}
