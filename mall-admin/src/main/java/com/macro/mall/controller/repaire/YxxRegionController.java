package com.macro.mall.controller.repaire;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.example.YxxRegionExample;
import com.macro.mall.mapper.YxxRegionMapper;
import com.macro.mall.model.YxxRegion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Paradise
 */
@Api(tags = "8.2 系统管理-区域管理")
@RestController
@RequestMapping("/yxx/region")
public class YxxRegionController {

    private final YxxRegionMapper regionMapper;

    public YxxRegionController(YxxRegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxRegion>> page(String province, Integer enable, String name,
                                                    Integer pageNum, Integer pageSize) {
        YxxRegionExample example = new YxxRegionExample();
        YxxRegionExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(province)) {
            criteria.andProvinceEqualTo(province);
        }
        if (enable != null) {
            criteria.andEnableEqualTo(enable);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andRegionNameLike("%" + name + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<YxxRegion> list = regionMapper.selectByExample(example);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("全部")
    @GetMapping("/list")
    public CommonResult<List<YxxRegion>> list() {
        return CommonResult.success(regionMapper.selectByExample(new YxxRegionExample().createCriteria().andEnableEqualTo(1).example()));
    }

    @ApiOperation("删除")
    @PostMapping("/del/{id}")
    public CommonResult delete(@PathVariable Long id) {
        int x = regionMapper.deleteByPrimaryKey(id);
        if (x == 1) {
            return CommonResult.success(x);
        }
        return CommonResult.failed();
    }

    @ApiOperation("新增")
    @PostMapping("/create")
    public CommonResult create(@RequestBody YxxRegion region) {
        int x = regionMapper.insertSelective(region);
        if (x == 1) {
            return CommonResult.success(region);
        }
        return CommonResult.failed();
    }

    @ApiOperation("新增")
    @PostMapping("/update")
    public CommonResult update(@RequestBody YxxRegion region) {
        int x = regionMapper.updateByPrimaryKey(region);
        if (x == 1) {
            return CommonResult.success(region);
        }
        return CommonResult.failed();
    }


}
