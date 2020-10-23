package com.macro.mall.service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.dao.YxxOrderCommonDao;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.example.YxxOrderItemExample;
import com.macro.mall.example.YxxOrderStatusRecordExample;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.*;
import com.macro.mall.model.YxxOrderStatusRecord;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class YxxOrderCommonService {

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxMemberMapper memberMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderItemMapper orderItemMapper;
    private final PmsProductMapper productMapper;
    private final PmsProductSkuMapper productSkuMapper;
    private final YxxMemberAddressMapper memberAddressMapper;
    private final YxxOrderCommonDao orderCommonDao;

    public YxxOrderDetail detail(Long orderId) {
        YxxOrderDetail detail = new YxxOrderDetail();
        // 订单信息
        detail.setYxxOrder(orderCommonDao.queryInfoById(orderId));
        // 子订单信息
        detail.setItemList(orderItemMapper.selectByExample(new YxxOrderItemExample().createCriteria().andOrderIdEqualTo(orderId).example()));
        // 维修工单信息
        detail.setRepairRecord(repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example()));
        // 订单状态变更记录
        detail.setOrderStatusRecordList(orderStatusRecordMapper.selectByExample(new YxxOrderStatusRecordExample()
                .createCriteria().andOrderIdEqualTo(orderId).example().orderBy(YxxOrderStatusRecord.Column.createTime.desc())));
        return detail;
    }

    public CommonPage<YxxOrderInfo> pageQueryInfo(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryList(null, getOrderStatusArray(status));
        return CommonPage.restPage(orderInfoList);
    }

    /**
     * 后台管理分页查询
     *
     * @param query    查询参数 {@link OrderQuery}
     * @param pageNum  分页参数
     * @param pageSize 分页参数
     * @return {@link YxxOrderInfo}
     */
    public CommonPage<YxxOrderInfo> pageQueryInfo(OrderQuery query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryListByOrderQuery(query);
        return CommonPage.restPage(orderInfoList);
    }

    private Integer[] getOrderStatusArray(Integer status) {
        if (status == null) {
            return new Integer[0];
        }
        // 待确认
        if (status == 1) {
            return new Integer[]{CREATED.val(), DISTRIBUTING.val(), DISTRIBUTED.val(), RECEIVED.val()};
        }
        // 进行中
        if (status == 2) {
            return new Integer[]{WAITED_GET.val(), SET_OFF.val(), ARRIVED.val(), OFFERED.val(),
                    OFFER_CONFIRMED.val(), REPAIRED.val(), REPAIRING.val()};
        }
        // 待评价
        if (status == 3) {
            return new Integer[]{PAYED.val()};
        }
        if (status == 4) {
            return new Integer[]{FREE_CANCEL.val(), ARRIVED_CANCEL.val(), CS_CANCEL.val(), COMPLETED.val()};
        }
        return new Integer[0];
    }

}
