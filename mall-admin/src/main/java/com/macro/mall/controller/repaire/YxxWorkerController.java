package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.YxxWorkerBody;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.impl.YxxWorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Paradise
 */
@Api(tags = "4.2 垚修修维修工管理")
@RestController
@RequestMapping("/yxx/worker")
public class YxxWorkerController {
    private final YxxWorkerService yxxWorkerService;

    public YxxWorkerController(YxxWorkerService yxxWorkerService) {

        this.yxxWorkerService = yxxWorkerService;
    }

    @ApiOperation("新增维修工")
    @PostMapping("/create")
    public CommonResult create(@RequestBody YxxWorkerBody worker) {
        YxxWorker yxxWorker = yxxWorkerService.create(worker);
        return CommonResult.success(yxxWorker);
    }

    @ApiOperation("新增维修工")
    @PostMapping("/update")
    public CommonResult update(@RequestBody YxxWorkerBody worker) {
        YxxWorker yxxWorker = yxxWorkerService.update(worker);
        return CommonResult.success(yxxWorker);
    }

    @ApiOperation("更改状态")
    @PostMapping("/enable/{id}")
    public CommonResult enable(@PathVariable Long id, Integer enable) {
        int x = yxxWorkerService.changeStatus(id, enable);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除")
    @PostMapping("/del/{id}")
    public CommonResult del(@PathVariable Long id) {
        int x = yxxWorkerService.del(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }


    @ApiOperation("分页查询")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxWorker>> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                                    String keywords) {
        return CommonResult.success(CommonPage.restPage(yxxWorkerService.page(keywords, pageNum, pageSize)));
    }

    @ApiOperation("根据父级ID-分页查询")
    @GetMapping("/page/{parentId}")
    public CommonResult<CommonPage<YxxWorker>> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                                    @PathVariable Long parentId) {
        return CommonResult.success(CommonPage.restPage(yxxWorkerService.listByParentId(pageNum, pageSize, parentId)));
    }


}
