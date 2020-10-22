package com.macro.mall.portal.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.YxxMember;
import com.macro.mall.portal.config.WxMaConfiguration;
import com.macro.mall.portal.service.impl.YxxMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * 会员登录注册管理Controller
 *
 * @author macro
 * @date 2018/8/3
 */
@Slf4j
@Api(tags = "1. 登录注册相关")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {
    private final static String APP_ID = "wxc5045e7d2cb2224a";

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final YxxMemberService memberService;

    public UmsMemberController(YxxMemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 登陆接口
     */
    @ApiOperation("微信授权登录")
    @GetMapping("/login")
    public CommonResult login(String code) {
        if (StringUtils.isBlank(code)) {
            return CommonResult.failed("Code 不能为空");
        }
        final WxMaService wxService = WxMaConfiguration.getMaService(APP_ID);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            String token = memberService.login(session);
            Map<String, Object> tokenMap = new HashMap<>(4);
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            tokenMap.put("wxSession", session);
            return CommonResult.success(tokenMap);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return CommonResult.failed(e.getLocalizedMessage());
        }
    }


    @ApiOperation("接口调试用：登录")
    @RequestMapping(value = "/login-test", method = RequestMethod.POST)
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @ApiOperation("获取用户信息接口")
    @GetMapping("/wx-info")
    public CommonResult wxInfo(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(APP_ID);
        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return CommonResult.failed("");
        }
        // 解密用户信息
        WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);
        memberService.updateWxInfo(userInfo);
        return CommonResult.success(userInfo);
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @ApiOperation("获取用户绑定手机号信息")
    @GetMapping("/phone")
    public CommonResult phone(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(APP_ID);
        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return CommonResult.failed();
        }
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        memberService.updateWxPhoneInfo(phoneNoInfo);
        return CommonResult.success(phoneNoInfo);
    }

    @ApiIgnore
    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        memberService.register(username, password, telephone, authCode);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("个人中心-获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        YxxMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @ApiOperation("切换站点区域")
    @PostMapping("/region/switch")
    public CommonResult changeRegion(Principal principal, Long regionId) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        memberService.updateRegion(regionId);
        return CommonResult.success("");
    }

    @ApiIgnore
    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiIgnore
    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String password,
                                       @RequestParam String authCode) {
        memberService.updatePassword(telephone, password, authCode);
        return CommonResult.success(null, "密码修改成功");
    }

    @ApiIgnore
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
