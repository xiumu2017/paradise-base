package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxMemberAddress;
import com.macro.mall.portal.service.impl.YxxMemberAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员收货地址管理Controller
 *
 * @author macro
 * @date 2018/8/28
 */
@Api(tags = "5.1服务地址管理")
@RestController
@RequestMapping("/member/address")
public class YxxMemberAddressController {
    private final YxxMemberAddressService addressService;

    public YxxMemberAddressController(YxxMemberAddressService addressService) {
        this.addressService = addressService;
    }

    @ApiOperation("添加地址")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody YxxMemberAddress address) {
        int count = addressService.add(address);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除地址")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = addressService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改地址")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody YxxMemberAddress address) {
        int count = addressService.update(id, address);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改地址-设置为默认地址")
    @RequestMapping(value = "/set-default/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult setDefault(@PathVariable Long id) {
        int count = addressService.setDefault(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("显示所有地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<YxxMemberAddress>> list() {
        List<YxxMemberAddress> addressList = addressService.list();
        return CommonResult.success(addressList);
    }

    @ApiOperation("获取地址详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<YxxMemberAddress> getItem(@PathVariable Long id) {
        YxxMemberAddress address = addressService.getItem(id);
        return CommonResult.success(address);
    }
}
