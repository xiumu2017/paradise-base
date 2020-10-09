package com.macro.mall.controller.repaire;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsMember;
import com.macro.mall.service.UmsMemberLevelService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paradise
 */
@Api(tags = "会员管理")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/member")
public class UmsMemberController {

    private final UmsMemberLevelService umsMemberLevelService;

    @GetMapping("/info")
    public CommonResult<UmsMember> info() {
        return CommonResult.success(new UmsMember());
    }

}
