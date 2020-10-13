package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.example.YxxHomeBannerExample;
import com.macro.mall.example.YxxHomeCostExample;
import com.macro.mall.example.YxxHomeQaExample;
import com.macro.mall.mapper.YxxHomeBannerMapper;
import com.macro.mall.mapper.YxxHomeCostMapper;
import com.macro.mall.mapper.YxxHomeQaMapper;
import com.macro.mall.model.YxxHomeBanner;
import com.macro.mall.model.YxxHomeCost;
import com.macro.mall.model.YxxHomeQa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "系统管理-基本信息")
@RestController
@RequestMapping("/yxx/system-config")
public class YxxSystemConfigController {

    private final YxxHomeBannerMapper yxxHomeBannerMapper;
    private final YxxHomeQaMapper yxxHomeQaMapper;
    private final YxxHomeCostMapper costMapper;

    public YxxSystemConfigController(YxxHomeBannerMapper yxxHomeBannerMapper, YxxHomeQaMapper yxxHomeQaMapper, YxxHomeCostMapper costMapper) {
        this.yxxHomeBannerMapper = yxxHomeBannerMapper;
        this.yxxHomeQaMapper = yxxHomeQaMapper;
        this.costMapper = costMapper;
    }

    @ApiOperation("根据区域ID查询首页轮播图列表")
    @GetMapping("/banner/list/{regionId}")
    public CommonResult<List<YxxHomeBanner>> bannerList(@PathVariable Long regionId) {
        YxxHomeBannerExample example = new YxxHomeBannerExample();
        example.createCriteria().andDeletedEqualTo(0).andRegionIdEqualTo(regionId);
        example.setOrderByClause("sort");
        List<YxxHomeBanner> list = yxxHomeBannerMapper.selectByExample(example);
        return CommonResult.success(list);
    }

    @ApiOperation("首页轮播图-删除")
    @PostMapping("/banner/del/{id}")
    public CommonResult deleteBanner(@PathVariable Long id) {
        int x = yxxHomeBannerMapper.deleteByPrimaryKey(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("首页轮播图-新增")
    @PostMapping("/banner/create")
    public CommonResult createBanner(@RequestBody YxxHomeBanner banner) {
        int x = yxxHomeBannerMapper.insertSelective(banner);
        if (x == 1) {
            return CommonResult.success(banner);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据区域ID查询首页QA列表")
    @GetMapping("/qa/list/{regionId}")
    public CommonResult<List<YxxHomeQa>> qaList(@PathVariable Long regionId) {
        YxxHomeQaExample example = new YxxHomeQaExample();
        example.createCriteria().andDeletedEqualTo(0).andRegionIdEqualTo(regionId);
        example.setOrderByClause("sort");
        List<YxxHomeQa> list = yxxHomeQaMapper.selectByExample(example);
        return CommonResult.success(list);
    }

    @ApiOperation("QA-删除")
    @PostMapping("/qa/del/{id}")
    public CommonResult deleteQa(@PathVariable Long id) {
        int x = yxxHomeQaMapper.deleteByPrimaryKey(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("QA-新增")
    @PostMapping("/qa/create")
    public CommonResult createQa(@RequestBody YxxHomeQa qa) {
        int x = yxxHomeQaMapper.insertSelective(qa);
        if (x == 1) {
            return CommonResult.success(qa);
        }
        return CommonResult.failed();
    }

    @ApiOperation("QA-更新")
    @PostMapping("/qa/update")
    public CommonResult qaUpdate(@RequestBody YxxHomeQa qa) {
        int x = yxxHomeQaMapper.updateByPrimaryKeySelective(qa);
        if (x == 1) {
            return CommonResult.success(qa);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据区域ID查询公共费用列表")
    @GetMapping("/cost/list/{regionId}")
    public CommonResult<List<YxxHomeCost>> costList(@PathVariable Long regionId) {
        YxxHomeCostExample example = new YxxHomeCostExample();
        example.createCriteria().andRegionIdEqualTo(regionId);
        example.setOrderByClause("sort");
        List<YxxHomeCost> list = costMapper.selectByExample(example);
        return CommonResult.success(list);
    }

    @ApiOperation("公共费用-删除")
    @PostMapping("/qa/del/{id}")
    public CommonResult deleteCost(@PathVariable Long id) {
        int x = costMapper.deleteByPrimaryKey(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("公共费用-新增")
    @PostMapping("/qa/create")
    public CommonResult createQa(@RequestBody YxxHomeCost cost) {
        int x = costMapper.insertSelective(cost);
        if (x == 1) {
            return CommonResult.success(cost);
        }
        return CommonResult.failed();
    }

    @ApiOperation("公共费用-更新")
    @PostMapping("/cost/update")
    public CommonResult costUpdate(@RequestBody YxxHomeCost cost) {
        int x = costMapper.updateByPrimaryKeySelective(cost);
        if (x == 1) {
            return CommonResult.success(cost);
        }
        return CommonResult.failed();
    }

}
