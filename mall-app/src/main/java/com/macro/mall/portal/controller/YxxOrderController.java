package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.service.impl.YxxOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/8/30
 */
@RestController
@Api(tags = "【未完成】2.订单相关")
@RequestMapping("/order")
public class YxxOrderController {
    private final YxxOrderService yxxOrderService;

    public YxxOrderController(YxxOrderService yxxOrderService) {
        this.yxxOrderService = yxxOrderService;
    }

    @ApiOperation("按状态分页获取用户订单列表")
    @ApiImplicitParam(name = "status", value = "订单状态：-1->全部；0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭",
            defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrderDetail>> list(@RequestParam Integer status,
                                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        CommonPage<OmsOrderDetail> orderPage = yxxOrderService.list(status, pageNum, pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("根据ID获取订单详情")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long orderId) {
        OmsOrderDetail orderDetail = yxxOrderService.detail(orderId);
        return CommonResult.success(orderDetail);
    }
//
//    @ApiOperation("创建新订单")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public CommonResult generateOrder(@RequestBody YxxOrderParam orderParam) {
//        Map<String, Object> result = yxxOrderService.generateOrder(orderParam);
//        return CommonResult.success(result, "下单成功");
//    }

    // 派单
    // 待派单 队列 ：单号、品类、坐标
    // （缓存） 接单状态中的维修工（单数限制 + 技能符合） （维修工ID，状态，当前坐标，可接单数量，可抢单数量...）
    // 计算位置和距离，计算等级+距离 权重得分 并排序
    //

    @ApiOperation("无需上门 - 取消订单")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public CommonResult cancelOrder(Long orderId) {
        int x = yxxOrderService.cancelOrder(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("确认上门-支付上门费")
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public CommonResult confirm(Long orderId) {
        int x = yxxOrderService.confirmToVisit(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("用户确认报价")
    @RequestMapping(value = "/price/confirm", method = RequestMethod.POST)
    public CommonResult confirmPrice(Long orderId) {
        int x = yxxOrderService.confirmPrice(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("不同意报价-取消订单")
    @RequestMapping(value = "/disagree/cancel", method = RequestMethod.POST)
    public CommonResult cancelUserOrder(Long orderId) {
        int x = yxxOrderService.cancelOrderDisagree(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("用户支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    public CommonResult paySuccess(@RequestParam Long orderId) {
        Integer count = yxxOrderService.paySuccess(orderId);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("用户删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public CommonResult deleteOrder(Long orderId) {
        int x = yxxOrderService.deleteOrder(orderId);
        if (x == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }
}
