package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class UmsMemberService {
    private final UmsMemberMapper umsMemberMapper;

    public List<UmsMember> list(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return umsMemberMapper.selectByExample(new UmsMemberExample());
    }

}
