package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 商品分类模块Controller
 *
 * @author macro
 * @date 2018/4/26
 */
@RestController
@Api(tags = "1.1 服务分类管理")
@RequestMapping("/product/category")
@Validated
public class YxxProductCategoryController {
    private final PmsProductCategoryService productCategoryService;

    public YxxProductCategoryController(PmsProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @ApiOperation("添加服务分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody @Validated PmsProductCategoryParam productCategoryParam) {
        int count = productCategoryService.create(productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改服务分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id,
                               @Validated @RequestBody PmsProductCategoryParam productCategoryParam) {
        int count = productCategoryService.update(id, productCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据父级ID-分页查询服务分类", hidden = true)
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(required = false) Long regionId,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategory> productCategoryList = productCategoryService.getList(parentId, pageSize, pageNum,regionId);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @ApiOperation("分页查询服务分类-包含子节点")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductCategoryWithChildrenItem>> page(@RequestParam(required = false) Long parentId,
                                                                             @RequestParam(required = false) String keywords,
                                                                             @RequestParam(required = false) Long regionId,
                                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductCategoryWithChildrenItem> productCategoryList = productCategoryService.select4Page(parentId, pageSize, pageNum, keywords,regionId);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @ApiOperation("根据id获取服务分类详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductCategory> getItem(@PathVariable Long id) {
        PmsProductCategory productCategory = productCategoryService.getItem(id);
        return CommonResult.success(productCategory);
    }

    @ApiOperation("删除分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult delete(@PathVariable Long id) {
        int count = productCategoryService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiIgnore
    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids, @RequestParam("showStatus") Integer showStatus) {
        int count = productCategoryService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
