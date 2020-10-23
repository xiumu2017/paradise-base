package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.service.YxxOrderCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 *
 * @author macro
 * @date 2018/10/11
 */
@RestController
@Api(tags = "2.0 订单管理")
@RequestMapping("/yxx/order")
public class YxxOrderController {
    private final YxxOrderCommonService orderCommonService;

    public YxxOrderController(YxxOrderCommonService orderCommonService) {
        this.orderCommonService = orderCommonService;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<CommonPage<YxxOrderInfo>> list(OrderQuery queryParam,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        CommonPage<YxxOrderInfo> orderPage = orderCommonService.pageQueryInfo(queryParam, pageNum, pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<YxxOrderDetail> detail(@PathVariable Long id) {
        YxxOrderDetail detail = orderCommonService.detail(id);
        return CommonResult.success(detail);
    }

}
