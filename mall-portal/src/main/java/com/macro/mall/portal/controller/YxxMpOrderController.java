package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.portal.domain.YxxOrderComment;
import com.macro.mall.portal.domain.YxxOrderParam;
import com.macro.mall.portal.service.impl.YxxMpOrderService;
import com.macro.mall.service.YxxOrderCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/8/30
 */
@RestController
@Api(tags = "4.订单管理")
@RequestMapping("/order")
public class YxxMpOrderController {
    private final YxxMpOrderService yxxMpOrderService;
    private final YxxOrderCommonService orderCommonService;

    public YxxMpOrderController(YxxMpOrderService yxxMpOrderService, YxxOrderCommonService orderCommonService) {
        this.yxxMpOrderService = yxxMpOrderService;
        this.orderCommonService = orderCommonService;
    }

    @ApiOperation("查询 - 分页获取用户订单列表")
    @ApiImplicitParam(name = "status", value = "1-待确认，2-进行中，3-待评价，4-历史订单（取消、完成）;默认全部", paramType = "query", dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<YxxOrderInfo>> queryList(@RequestParam(required = false) Integer status,
                                                            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                            @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        CommonPage<YxxOrderInfo> orderPage = yxxMpOrderService.pageQueryInfo(status, pageNum, pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("查询 - 订单状态")
    @PostMapping("/status/query/{orderId}")
    public CommonResult queryOrderStatus(@PathVariable Long orderId) {
        return CommonResult.success(yxxMpOrderService.yxxOrder(orderId));
    }

    @ApiOperation("查询 - 订单详情")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public CommonResult<YxxOrderDetail> queryDetail(@PathVariable Long orderId) {
        // 状态变更记录
        // 报价单
        // 维修工单
        YxxOrderDetail orderDetail = orderCommonService.detail(orderId);
        return CommonResult.success(orderDetail);
    }

    @ApiOperation("订单流程 - 创建新订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult orderCreate(@RequestBody @Validated YxxOrderParam orderParam) {
        YxxOrder result = yxxMpOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "下单成功");
    }

    @ApiOperation("订单流程 - 无需上门-取消订单")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public CommonResult orderCancel(Long orderId) {
        int x = yxxMpOrderService.cancelOrder(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 同意上门-支付上门费")
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public CommonResult orderConfirm(Long orderId) {
        int x = yxxMpOrderService.confirmToVisit(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 用户确认报价")
    @RequestMapping(value = "/price/confirm", method = RequestMethod.POST)
    public CommonResult orderConfirmPrice(Long orderId) {
        int x = yxxMpOrderService.confirmPrice(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 不同意报价-取消订单")
    @RequestMapping(value = "/disagree/cancel", method = RequestMethod.POST)
    public CommonResult orderDisagree(Long orderId) {
        int x = yxxMpOrderService.cancelOrderDisagree(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单流程 - 用户支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    public CommonResult paySuccess(@RequestParam Long orderId) {
        Integer count = yxxMpOrderService.paySuccess(orderId);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("订单操作 - 用户删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public CommonResult deleteOrder(Long orderId) {
        int x = yxxMpOrderService.deleteOrder(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("订单操作 - 评价订单")
    @PostMapping("/comment/{orderId}")
    public CommonResult commentOrder(@PathVariable Long orderId,
                                     @RequestBody YxxOrderComment orderComment) {
        int x = yxxMpOrderService.commentOrder(orderId, orderComment);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }
}
