package com.macro.mall.portal.domain;

import com.macro.mall.model.YxxMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * 会员详情封装
 *
 * @author macro
 * @date 2018/8/3
 */
public class MemberDetails implements UserDetails {
    private YxxMember yxxMember;

    public MemberDetails(YxxMember yxxMember) {
        this.yxxMember = yxxMember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Collections.singletonList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return yxxMember.getPassword();
    }

    @Override
    public String getUsername() {
        return yxxMember.getWxOpenId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return yxxMember.getEnable() == 1;
    }

    public YxxMember getYxxMember() {
        return yxxMember;
    }
}
