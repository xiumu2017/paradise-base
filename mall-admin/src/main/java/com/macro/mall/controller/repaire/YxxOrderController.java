package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.dto.YxxOrderQueryParam;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.service.impl.YxxOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private final YxxOrderService yxxOrderService;

    public YxxOrderController(YxxOrderService yxxOrderService) {
        this.yxxOrderService = yxxOrderService;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public CommonResult<CommonPage<YxxOrder>> list(YxxOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<YxxOrder> orderList = yxxOrderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<YxxOrderDetail> detail(@PathVariable Long id) {
        YxxOrderDetail detail = yxxOrderService.detail(id);
        return CommonResult.success(detail);
    }

}
