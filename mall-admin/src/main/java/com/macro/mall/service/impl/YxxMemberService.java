package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.example.YxxMemberExample;
import com.macro.mall.mapper.YxxMemberMapper;
import com.macro.mall.model.YxxMember;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Paradise
 */
@Service
public class YxxMemberService {
    private final YxxMemberMapper yxxMemberMapper;

    public YxxMemberService(YxxMemberMapper yxxMemberMapper) {
        this.yxxMemberMapper = yxxMemberMapper;
    }

    public List<YxxMember> page(String keywords, Integer pageNum, Integer pageSize) {
        YxxMemberExample yxxMemberExample = new YxxMemberExample();
        YxxMemberExample.Criteria criteria = yxxMemberExample.createCriteria();
        if (!StringUtils.isEmpty(keywords)) {
            criteria.andUsernameLike("%" + keywords + "%");
        }
        // TODO 需要查询上级名称
        PageHelper.startPage(pageNum, pageSize);
        return yxxMemberMapper.selectByExample(yxxMemberExample);
    }

    public List<YxxMember> listByParentId(Integer pageNum, Integer pageSize, Long parentId) {
        YxxMemberExample yxxMemberExample = new YxxMemberExample();
        YxxMemberExample.Criteria criteria = yxxMemberExample.createCriteria();
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        PageHelper.startPage(pageNum, pageSize);
        return yxxMemberMapper.selectByExample(yxxMemberExample);
    }

}
