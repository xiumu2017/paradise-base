package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxRepairRecord;
import com.macro.mall.portal.service.impl.YxxAppOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/8/30
 */
@RestController
@Api(tags = "2.订单相关")
@RequestMapping("/order")
public class YxxAppOrderController {
    private final YxxAppOrderService yxxAppOrderService;

    public YxxAppOrderController(YxxAppOrderService yxxAppOrderService) {
        this.yxxAppOrderService = yxxAppOrderService;
    }

    @ApiOperation("按状态分页获取用户订单列表")
    @ApiImplicitParam(name = "status", value = "参见数据字典表", paramType = "query", dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<YxxOrder>> list(@RequestParam Integer status,
                                                   @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        CommonPage<YxxOrder> orderPage = yxxAppOrderService.page(status, pageNum, pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("根据ID获取订单详情")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public CommonResult<YxxOrder> detail(@PathVariable Long orderId) {
        YxxOrder orderDetail = yxxAppOrderService.detail(orderId);
        return CommonResult.success(orderDetail);
    }

    @ApiOperation("查询系统分派订单")
    @GetMapping("/distribute/list")
    public CommonResult queryDistributeOrder() {
        return CommonResult.success(yxxAppOrderService.queryDistributeOrder());
    }

    @ApiOperation("分页查询抢单大厅订单列表")
    @GetMapping("/rush/list")
    public CommonResult<CommonPage<YxxOrder>> queryRushOrder(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        List<YxxOrder> orderList = yxxAppOrderService.queryRushOrder(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("订单流程 - 确认接单")
    @PostMapping(value = "/accept")
    public CommonResult accept(Long orderId) {
        int x = yxxAppOrderService.accept(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 拒绝接单")
    @PostMapping(value = "/refuse")
    public CommonResult refuse(Long orderId) {
        int x = yxxAppOrderService.refuse(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 抢单")
    @PostMapping(value = "/rush")
    public CommonResult rush(Long orderId) {
        int x = yxxAppOrderService.rush(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("抢单失败");
    }


    @ApiOperation("订单流程 - 已联系")
    @PostMapping(value = "/wait-get")
    public CommonResult waitGet(Long orderId) {
        int x = yxxAppOrderService.waitGet(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 已出发")
    @PostMapping(value = "/set-off")
    public CommonResult setOff(Long orderId) {
        int x = yxxAppOrderService.setOff(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 已到达")
    @PostMapping(value = "/arrive")
    public CommonResult arrive(Long orderId) {
        int x = yxxAppOrderService.arrive(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 提交报价 | 报价信息")
    @PostMapping(value = "/price")
    public CommonResult price(Long orderId, BigDecimal price, String json) {
        int x = yxxAppOrderService.confirmPrice(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("维修工单 - 提交")
    @PostMapping(value = "/repair-record/create")
    public CommonResult repairCreate(@RequestBody YxxRepairRecord repairRecord) {
        int x = yxxAppOrderService.repairRecordCreate(repairRecord);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("维修工单 - 查询")
    @GetMapping(value = "/repair-record/query")
    public CommonResult<YxxRepairRecord> repairRecordQuery(Long orderId) {
        return CommonResult.success(yxxAppOrderService.repairRecordQuery(orderId));
    }

    @ApiOperation("维修工单 - 更新")
    @PostMapping(value = "/repair-record/update")
    public CommonResult repairRecordUpdate(@RequestBody YxxRepairRecord repairRecord) {
        int x = yxxAppOrderService.repairRecordUpdate(repairRecord);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("维修工单 - 删除")
    @PostMapping(value = "/repair-record/delete")
    public CommonResult repairRecordDelete(Long id) {
        int x = yxxAppOrderService.repairRecordDelete(id);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 维修完成")
    @PostMapping(value = "/repair/finish")
    public CommonResult repairFinish(Long orderId) {
        int x = yxxAppOrderService.repairFinish(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 订单暂缓")
    @PostMapping(value = "/pause")
    public CommonResult pause(@RequestParam Long orderId) {
        Integer count = yxxAppOrderService.pause(orderId);
        return CommonResult.success(count);
    }

}
