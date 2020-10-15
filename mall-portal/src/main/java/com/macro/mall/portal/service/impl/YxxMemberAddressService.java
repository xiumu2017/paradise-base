package com.macro.mall.portal.service.impl;

import com.macro.mall.example.YxxMemberAddressExample;
import com.macro.mall.mapper.YxxMemberAddressMapper;
import com.macro.mall.model.YxxMember;
import com.macro.mall.model.YxxMemberAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户地址管理Service实现类
 *
 * @author macro
 * @date 2018/8/28
 */
@Service
public class YxxMemberAddressService {
    private final YxxMemberService memberService;
    private final YxxMemberAddressMapper addressMapper;

    public YxxMemberAddressService(YxxMemberService memberService, YxxMemberAddressMapper addressMapper) {
        this.memberService = memberService;
        this.addressMapper = addressMapper;
    }

    public int add(YxxMemberAddress address) {
        YxxMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        return addressMapper.insert(address);
    }


    public int delete(Long id) {
        YxxMember currentMember = memberService.getCurrentMember();
        return addressMapper.deleteByPrimaryKey(id);
    }


    public int update(Long id, YxxMemberAddress address) {
        YxxMemberAddress yxxMemberAddress = addressMapper.selectByPrimaryKey(id);
        YxxMember currentMember = memberService.getCurrentMember();
        address.setDefaultStatus(yxxMemberAddress.getDefaultStatus());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public int setDefault(Long id) {
        YxxMember currentMember = memberService.getCurrentMember();
        YxxMemberAddress defaultAddress = addressMapper.selectOneByExample(
                new YxxMemberAddressExample().createCriteria().andMemberIdEqualTo(currentMember.getId())
                        .andDefaultStatusEqualTo(1).example()
        );
        // 原有的默认地址设为非默认
        if (defaultAddress != null) {
            if (defaultAddress.getId().equals(id)) {
                return 1;
            }
            addressMapper.updateByPrimaryKeySelective(YxxMemberAddress.builder()
                    .id(id).defaultStatus(1)
                    .build(), YxxMemberAddress.Column.defaultStatus);
            defaultAddress.setDefaultStatus(0);
            addressMapper.updateByPrimaryKeySelective(defaultAddress, YxxMemberAddress.Column.defaultStatus);
        }
        return 1;

    }

    public List<YxxMemberAddress> list() {
        YxxMember currentMember = memberService.getCurrentMember();
        YxxMemberAddressExample example = new YxxMemberAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);
    }


    public YxxMemberAddress getItem(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
