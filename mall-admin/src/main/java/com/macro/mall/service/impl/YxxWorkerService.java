package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.model.YxxWorker;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Paradise
 */
@Service
public class YxxWorkerService {
    private final YxxWorkerMapper yxxWorkerMapper;

    public YxxWorkerService(YxxWorkerMapper yxxWorkerMapper) {
        this.yxxWorkerMapper = yxxWorkerMapper;
    }

    public List<YxxWorker> page(String keywords, Integer pageNum, Integer pageSize) {
        YxxWorkerExample yxxMemberExample = new YxxWorkerExample();
        YxxWorkerExample.Criteria criteria = yxxMemberExample.createCriteria();
        criteria.andEnableNotEqualTo(3);
        if (!StringUtils.isEmpty(keywords)) {
            criteria.andUsernameLike("%" + keywords + "%");
        }
        // TODO 需要查询上级名称
        PageHelper.startPage(pageNum, pageSize);
        return yxxWorkerMapper.selectByExample(yxxMemberExample);
    }

    public List<YxxWorker> listByParentId(Integer pageNum, Integer pageSize, Long parentId) {
        YxxWorkerExample yxxMemberExample = new YxxWorkerExample();
        YxxWorkerExample.Criteria criteria = yxxMemberExample.createCriteria();
        criteria.andEnableNotEqualTo(3);
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        PageHelper.startPage(pageNum, pageSize);
        return yxxWorkerMapper.selectByExample(yxxMemberExample);
    }

    public YxxWorker create(YxxWorker worker) {
        yxxWorkerMapper.insert(worker);
        return worker;
    }

    public int changeStatus(Long id, Integer enable) {
        YxxWorker worker = new YxxWorker();
        worker.setId(id);
        worker.setEnable(enable);
        return yxxWorkerMapper.updateByPrimaryKeySelective(worker);
    }

    public int del(Long id) {
        YxxWorker worker = new YxxWorker();
        worker.setId(id);
        worker.setEnable(3);
        return yxxWorkerMapper.updateByPrimaryKeySelective(worker);
    }

    public YxxWorker update(YxxWorker worker) {
        yxxWorkerMapper.updateByPrimaryKeySelective(worker);
        return worker;
    }
}
