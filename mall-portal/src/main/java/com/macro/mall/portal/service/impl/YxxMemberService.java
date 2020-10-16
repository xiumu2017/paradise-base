package com.macro.mall.portal.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.macro.mall.common.exception.Asserts;
import com.macro.mall.common.utils.GeneratorUtil;
import com.macro.mall.example.YxxMemberExample;
import com.macro.mall.mapper.YxxMemberMapper;
import com.macro.mall.model.YxxMember;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.UmsMemberCacheService;
import com.macro.mall.security.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class YxxMemberService {
    private final YxxMemberMapper memberMapper;
    @Lazy
    private final PasswordEncoder passwordEncoder;
    @Lazy
    private final JwtTokenUtil jwtTokenUtil;
    private final UmsMemberCacheService memberCacheService;

    private YxxMember getByUsername(String username) {
        YxxMemberExample example = new YxxMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        return memberMapper.selectOneByExample(example);
    }

    private YxxMember getByWxOpenId(String openId) {
        return memberMapper.selectOneByExample(new YxxMemberExample().createCriteria().andWxOpenIdEqualTo(openId).example());
    }

    public YxxMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    public void register(String username, String password, String telephone, String authCode) {
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        //查询是否已有该用户
        com.macro.mall.example.YxxMemberExample example = new com.macro.mall.example.YxxMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<YxxMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            Asserts.fail("该用户已经存在");
        }
        //没有该用户进行添加操作
        YxxMember umsMember = new YxxMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
    }

    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public void updatePassword(String telephone, String password, String authCode) {
        YxxMemberExample example = new YxxMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<YxxMember> memberList = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(memberList)) {
            Asserts.fail("该账号不存在");
        }
        //验证验证码
        if (!verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        YxxMember umsMember = memberList.get(0);
        umsMember.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
    }

    public YxxMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        MemberDetails memberDetails = (MemberDetails) auth.getPrincipal();
        return memberDetails.getYxxMember();
    }

    /**
     * 切换区域
     *
     * @param regionId 区域ID
     * @return 更新结果
     */
    public int changeRegion(Long regionId) {
        YxxMember member = getCurrentMember();
        member.setRegionId(regionId);
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    public UserDetails loadUserByUsername(String username) {
        YxxMember member = getByUsername(username);
        if (member != null) {
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public UserDetails loadUserByOpenId(String openId) {
        YxxMember member = getByWxOpenId(openId);
        if (member != null) {
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    /**
     * 验证码校验
     *
     * @param authCode  验证码
     * @param telephone 手机号码
     * @return 验证结果
     */
    private boolean verifyAuthCode(String authCode, String telephone) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }

    public String login(WxMaJscode2SessionResult session) {
        String token = null;
        // 判断用户是否存在
        YxxMember member = this.getByWxOpenId(session.getOpenid());
        if (member == null) {
            memberMapper.insert(YxxMember.builder()
                    .wxOpenId(session.getOpenid()).wxUnionId(session.getUnionid())
                    .enable(1).createTime(new Date())
                    .build());
            // 生成邀请码
            this.invitationCodeGenerator(session.getOpenid());
        }
        try {
            UserDetails userDetails = loadUserByOpenId(session.getOpenid());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    private void invitationCodeGenerator(String openId) {
        YxxMember member = this.getByWxOpenId(openId);
        member.setInvitationCode(GeneratorUtil.generatePromotionCode(member.getId()));
        memberMapper.updateByPrimaryKeySelective(member, YxxMember.Column.invitationCode);
    }

    public void updateWxInfo(WxMaUserInfo userInfo) {
        log.info(userInfo.toString());
        YxxMember member = this.getByWxOpenId(userInfo.getOpenId());
        if (member != null) {
            member.setIcon(userInfo.getAvatarUrl());
            log.info(userInfo.getGender());
            member.setUsername(userInfo.getNickName());
//            member.setSex(userInfo.getGender());
            memberMapper.updateByPrimaryKeySelective(member, YxxMember.Column.icon, YxxMember.Column.username);
        }
    }

    public void updateWxPhoneInfo(WxMaPhoneNumberInfo phoneNoInfo) {
        log.info(phoneNoInfo.toString());
        YxxMember member = this.getCurrentMember();
        if (member != null) {
            member.setPhone(phoneNoInfo.getPurePhoneNumber());
            memberMapper.updateByPrimaryKeySelective(member, YxxMember.Column.phone);
        }
    }

    public void updateRegion(Long regionId) {
        YxxMember member = this.getCurrentMember();
        member.setRegionId(regionId);
        memberMapper.updateByPrimaryKeySelective(member, YxxMember.Column.regionId);
    }
}
