package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxMember;
import com.macro.mall.service.impl.YxxMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author Paradise
 */
@Api(tags = "垚修修会员管理")
@RestController
@RequestMapping("/yxx/member")
public class YxxMemberController {
    private final YxxMemberService yxxMemberService;

    public YxxMemberController(YxxMemberService yxxMemberService) {
        this.yxxMemberService = yxxMemberService;
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public CommonResult<CommonPage<YxxMember>> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                                    String keywords) {
        return CommonResult.success(CommonPage.restPage(yxxMemberService.page(keywords, pageNum, pageSize)));
    }

    @ApiOperation("根据父级ID-分页查询")
    @GetMapping("/page/{parentId}")
    public CommonResult<CommonPage<YxxMember>> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                                    @PathVariable Long parentId) {
        return CommonResult.success(CommonPage.restPage(yxxMemberService.listByParentId(pageNum, pageSize, parentId)));
    }


}
