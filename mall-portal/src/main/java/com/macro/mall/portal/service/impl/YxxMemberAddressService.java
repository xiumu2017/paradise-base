package com.macro.mall.portal.service.impl;

import com.macro.mall.example.YxxMemberAddressExample;
import com.macro.mall.mapper.YxxMemberAddressMapper;
import com.macro.mall.model.YxxMember;
import com.macro.mall.model.YxxMemberAddress;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        address.setCreateTime(new Date());
        address.setUpdateTime(new Date());
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
        address.setUpdateTime(new Date());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public int setDefault(Long id) {
        YxxMember currentMember = memberService.getCurrentMember();
        YxxMemberAddress address = addressMapper.selectByPrimaryKey(id);
        // 取消默认
        if (address.getDefaultStatus() == 1) {
            address.setDefaultStatus(0);
            return addressMapper.updateByPrimaryKeySelective(address, YxxMemberAddress.Column.defaultStatus);
        } else {
            // 设置为默认地址
            // 查询已有的默认地址
            YxxMemberAddress defaultAddress = addressMapper.selectOneByExample(
                    new YxxMemberAddressExample().createCriteria().andMemberIdEqualTo(currentMember.getId())
                            .andDefaultStatusEqualTo(1).example()
            );
            if (defaultAddress != null) {
                // 原有的默认地址设为非默认
                defaultAddress.setDefaultStatus(0);
                addressMapper.updateByPrimaryKeySelective(defaultAddress, YxxMemberAddress.Column.defaultStatus);
            }
            return addressMapper.updateByPrimaryKeySelective(YxxMemberAddress.builder().id(id).defaultStatus(1).build(),
                    YxxMemberAddress.Column.defaultStatus);
        }

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
