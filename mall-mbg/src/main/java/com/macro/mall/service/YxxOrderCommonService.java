package com.macro.mall.service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.dao.YxxOrderCommonDao;
import com.macro.mall.domain.OrderQuery;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.domain.YxxOrderInfo;
import com.macro.mall.domain.YxxOrderStatusRecordInfo;
import com.macro.mall.enums.OrderStatusUtil;
import com.macro.mall.example.YxxOrderStatusRecordExample;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.YxxMemberMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxRepairRecordMapper;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxWorker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class YxxOrderCommonService {

    private final YxxMemberMapper memberMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderCommonDao orderCommonDao;
    private final YxxWorkerMapper workerMapper;

    public YxxOrderDetail detail(Long orderId) {
        YxxOrderDetail detail = new YxxOrderDetail();
        // 订单信息
        YxxOrderInfo orderInfo = orderCommonDao.queryInfoById(orderId);
        orderInfo.setOrderStatusName(OrderStatusUtil.getStatusName(orderInfo.getOrderStatus()));
        detail.setYxxOrder(orderInfo);
        // 子订单信息
        detail.setItemList(orderCommonDao.queryOrderItemList(orderId));
        // 维修工单信息
        detail.setRepairRecord(repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example()));
        // 订单状态变更记录
        List<YxxOrderStatusRecord> recordList = orderStatusRecordMapper.selectByExample(new YxxOrderStatusRecordExample()
                .createCriteria().andOrderIdEqualTo(orderId).example().orderBy(YxxOrderStatusRecord.Column.createTime.desc()));
        List<YxxOrderStatusRecordInfo> recordInfoList = new ArrayList<>();
        for (YxxOrderStatusRecord record : recordList) {
            recordInfoList.add(new YxxOrderStatusRecordInfo(record));
        }
        detail.setOrderStatusRecordList(recordInfoList);
        detail.setMember(memberMapper.selectByPrimaryKey(orderInfo.getMemberId()));
        detail.setWorker(workerMapper.selectByPrimaryKey(orderInfo.getWorkerId()));
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

    /**
     * // 处理状态名称
     *
     * @param orderInfoList 订单列表
     */
    private void dealStatusDesc(List<YxxOrderInfo> orderInfoList) {
        if (!orderInfoList.isEmpty()) {
            orderInfoList.forEach(yxxOrderInfo -> yxxOrderInfo.setOrderStatusName(
                    OrderStatusUtil.getStatusName(yxxOrderInfo.getOrderStatus())));
        }
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

    /**
     * 维修工查询指派订单列表
     *
     * @param worker 维修工
     * @return 订单列表
     */
    public List<YxxOrderInfo> queryDistributeOrder(YxxWorker worker) {
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryInfoByWorkerId(worker.getId(), DISTRIBUTED.val());
        this.dealStatusDesc(orderInfoList);
        return orderInfoList;
    }

    public List<YxxOrderInfo> queryRushOrders(Integer pageNum, Integer pageSize) {
        List<Long> ids = distributorService.getRushOrderIds();
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrderInfo> orderInfoList = orderCommonDao.queryRushOrders(ids, DISTRIBUTED.val());
        this.dealStatusDesc(orderInfoList);
        return orderInfoList;
    }
}
