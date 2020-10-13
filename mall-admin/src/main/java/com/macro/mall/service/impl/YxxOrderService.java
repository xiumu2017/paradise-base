package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.YxxOrderDao;
import com.macro.mall.dto.OmsOrderDetail;
import com.macro.mall.dto.YxxOrderQueryParam;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.model.YxxOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 *
 * @author Paradise
 * @date 2020-10-10
 */
@Service
@AllArgsConstructor
public class YxxOrderService {
    private final YxxOrderMapper yxxOrderMapper;
    private final YxxOrderStatusRecordMapper statusRecordMapper;
    private final YxxOrderDao yxxOrderDao;

    public List<YxxOrder> list(YxxOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return yxxOrderDao.getList(queryParam);
    }

    public int delete(List<Long> ids) {
        YxxOrderExample example = new YxxOrderExample();
        example.createCriteria().andIdIn(ids);
        return yxxOrderMapper.deleteByExample(example);
    }

    public OmsOrderDetail detail(Long id) {
        return yxxOrderDao.getDetail(id);
    }

}
