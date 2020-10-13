package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxProductChargeStandard;
import com.macro.mall.service.impl.PmsProductChargeStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "收费标准管理")
@Slf4j
@RestController
@RequestMapping("/chargeStandard")
public class PmsProductChargeStandardController {
    private final PmsProductChargeStandardService chargeStandardService;

    public PmsProductChargeStandardController(PmsProductChargeStandardService chargeStandardService) {
        this.chargeStandardService = chargeStandardService;
    }

    @ApiOperation("新增收费标准")
    @PostMapping("/create")
    public CommonResult<YxxProductChargeStandard> create(YxxProductChargeStandard chargeStandard) {
        return CommonResult.success(chargeStandardService.create(chargeStandard));
    }

    @ApiOperation("更新收费标准")
    @PostMapping("/update")
    public CommonResult<YxxProductChargeStandard> update(YxxProductChargeStandard chargeStandard) {
        return CommonResult.success(chargeStandardService.update(chargeStandard));
    }

    @ApiOperation("根据主键删除")
    @PostMapping("/del/{id}")
    public CommonResult del(@PathVariable Long id) {
        int x = chargeStandardService.del(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxProductChargeStandard>> page(String name, Integer enable, Integer pageNum, Integer pageSize) {
        List<YxxProductChargeStandard> list = chargeStandardService.page(name, pageNum, pageSize, enable);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("修改状态")
    @PostMapping("/enable/{id}")
    public CommonResult enable(@PathVariable Long id, Integer enable) {
        int x = chargeStandardService.changeStatus(id, enable);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }
}
