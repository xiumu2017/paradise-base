package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxWorkerCertificate;
import com.macro.mall.portal.domain.WorkerSkilledProductInfo;
import com.macro.mall.portal.domain.YxxWorkerUpdateParam;
import com.macro.mall.portal.service.impl.YxxWorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 垚修修 维修工 个人信息
 *
 * @author Paradise
 */
@Api(tags = "4.个人信息相关")
@RestController
@RequestMapping("/worker-info")
public class YxxWorkerInfoController {
    private final YxxWorkerService workerService;

    public YxxWorkerInfoController(YxxWorkerService workerService) {
        this.workerService = workerService;
    }


    @ApiOperation("更新个人信息")
    @PostMapping("/update")
    public CommonResult updateInfo(@RequestBody YxxWorkerUpdateParam worker) {
        // 联系地址
        int x = workerService.updateInfo(worker);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("证书列表")
    @GetMapping("/certificate/list")
    public CommonResult<List<YxxWorkerCertificate>> certificateCreate() {
        return CommonResult.success(workerService.certificateList());
    }

    @ApiOperation("证书上传")
    @PostMapping("/certificate/create")
    public CommonResult<YxxWorkerCertificate> certificateCreate(@RequestBody YxxWorkerCertificate certificate) {
        int x = workerService.certificateCreate(certificate);
        if (x == 1) {
            return CommonResult.success(certificate);
        }
        return CommonResult.failed();
    }

    @ApiOperation("证书删除")
    @PostMapping("/certificate/delete/{id}")
    public CommonResult certificateCreate(@PathVariable Long id) {
        int x = workerService.certificateDelete(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("服务位置坐标更新")
    @PostMapping("/address/update")
    public CommonResult addressUpdate(String address, String location) {
        int x = workerService.addressUpdate(address, location);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("擅长服务品类查询")
    @GetMapping("/skilled-product/list")
    public CommonResult<List<WorkerSkilledProductInfo>> skilledProductList() {
        return CommonResult.success(workerService.skilledProductList());
    }

    @ApiOperation("擅长服务品类配置")
    @PostMapping("/skilled-product/config")
    public CommonResult skilledProductConfig(@RequestParam("ids") List<Long> ids) {
        // 擅长品类 配置 - 需要先配置区域
        int x = workerService.skilledProductConfig(ids);
        if (x > 0) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    // 服务分查询 明细 变更记录

}
