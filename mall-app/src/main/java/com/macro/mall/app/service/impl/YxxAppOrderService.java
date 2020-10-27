package com.macro.mall.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.app.domain.OrderPrice;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxRepairRecordMapper;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxRepairRecord;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.YxxOrderCommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Paradise
 */
@Service
public class YxxAppOrderService {

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxWorkerService workerService;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final DistributorService distributorService;
    private final YxxOrderCommonService orderCommonService;

    public YxxAppOrderService(YxxOrderMapper yxxOrderMapper,
                              YxxWorkerService workerService, YxxOrderStatusRecordMapper orderStatusRecordMapper,
                              YxxRepairRecordMapper repairRecordMapper, DistributorService distributorService,
                              YxxOrderCommonService orderCommonService) {
        this.yxxOrderMapper = yxxOrderMapper;
        this.workerService = workerService;
        this.orderStatusRecordMapper = orderStatusRecordMapper;
        this.repairRecordMapper = repairRecordMapper;
        this.distributorService = distributorService;
        this.orderCommonService = orderCommonService;
    }

    public Integer paySuccess(Long orderId) {
        // 支付成功 - 更改状态
        // 更新维修工的余额
        YxxOrder order = YxxOrder.builder().id(orderId).orderStatus(OrderStatus.PAYED.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    public int cancelOrder(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.FREE_CANCEL);
    }

    public YxxOrder detail(Long orderId) {
        return yxxOrderMapper.selectByPrimaryKey(orderId);
    }

    public int deleteOrder(Long orderId) {
        return yxxOrderMapper.deleteByPrimaryKey(orderId);
    }

    public int confirmToVisit(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.WAITED_GET);
    }

    private int updateOrderStatus(Long orderId, OrderStatus status) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new RuntimeException("OrderId not Exist");
        }
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), status);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(status.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    private void insertStatusRecord(Long orderId, Integer originStatus, OrderStatus status) {
        // 保存状态变更记录
        orderStatusRecordMapper.insert(
                YxxOrderStatusRecord.builder()
                        .orderId(orderId).originStatus(originStatus)
                        .currentStatus(status.val())
                        .createTime(new Date())
                        .build());
    }

    public int confirmPrice(OrderPrice orderPrice) {
        // 保存报价信息 - 更新订单offerPrice
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderPrice.getOrderId());
        if (order == null) {
            throw new RuntimeException("OrderId not Exist");
        }
        // 判断订单状态
        // 保存状态变更记录
        insertStatusRecord(orderPrice.getOrderId(), order.getOrderStatus(), OrderStatus.OFFERED);
        // 更新订单状态
        order = YxxOrder.builder().id(orderPrice.getOrderId()).orderStatus(OrderStatus.OFFERED.val())
                .offerPrice(orderPrice.getPrice()).priceJson(orderPrice.getPriceJson()).updateTime(new Date())
                .build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus,
                YxxOrder.Column.offerPrice, YxxOrder.Column.priceJson, YxxOrder.Column.updateTime);
    }

    public int cancelOrderDisagree(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.ARRIVED_CANCEL);
    }

    public CommonPage<YxxOrder> page(Integer status, Integer pageNum, Integer pageSize) {
        YxxWorker worker = workerService.getCurrentWorker();
        YxxOrderExample example = new YxxOrderExample();
        YxxOrderExample.Criteria criteria = example.createCriteria();
        criteria.andWorkerIdEqualTo(worker.getId());
        criteria.when(status != null, criteria1 -> criteria1.andOrderStatusEqualTo(status));
        PageHelper.startPage(pageNum, pageSize);
        List<YxxOrder> orderList = yxxOrderMapper.selectByExample(example.orderBy(YxxOrder.Column.createTime.desc()));
        return CommonPage.restPage(orderList);
    }

    /**
     * 确认接单
     *
     * @param orderId 订单ID
     * @return 状态更新结果
     */
    @Transactional(rollbackFor = Exception.class)
    public int accept(Long orderId) {
        YxxWorker worker = workerService.getCurrentWorker();
        // 抢单，首先判断订单状态 需要加锁
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() != OrderStatus.DISTRIBUTED.val()) {
            return 0;
        }
        // 判断维修工每日抢单数量是否超限
        boolean result = orderCommonService.check(order, worker);
        if (!result) {
            return 0;
        }
        distributorService.removeFromWaitQueue(orderId);
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), OrderStatus.RECEIVED);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(OrderStatus.RECEIVED.val()).workerId(worker.getId()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus, YxxOrder.Column.workerId);
    }

    /**
     * 抢单
     *
     * @param orderId 订单ID
     * @return 状态更新结果
     */
    @Transactional(rollbackFor = Exception.class)
    public int rush(Long orderId) {
        YxxWorker worker = workerService.getCurrentWorker();
        // 抢单，首先判断订单状态 需要加锁
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
            return 0;
        }
        // 判断维修工每日抢单数量是否超限
        boolean result = orderCommonService.check(order, worker);
        if (!result) {
            return 0;
        }
        // 保存状态变更记录
        insertStatusRecord(orderId, order.getOrderStatus(), OrderStatus.RECEIVED);
        // 更新订单状态
        order = YxxOrder.builder().id(orderId).orderStatus(OrderStatus.RECEIVED.val()).workerId(worker.getId()).build();
        int x = yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus, YxxOrder.Column.workerId);
        if (x == 1) {
            distributorService.rushSuccess(orderId);
        }
        return x;
    }

    public int waitGet(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.WAITED_GET);
    }

    public int setOff(Long orderId) {
        // 判断订单状态
        return updateOrderStatus(orderId, OrderStatus.SET_OFF);
    }

    public int arrive(Long orderId) {
        YxxOrder order = yxxOrderMapper.selectByPrimaryKey(orderId);
        if (order != null) {
            // 判断订单类型
            if (order.getIsBargain() != 1) {
                return updateOrderStatus(orderId, OrderStatus.OFFER_CONFIRMED);
            }
        }
        return updateOrderStatus(orderId, OrderStatus.ARRIVED);
    }

    public int repairFinish(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.REPAIRED);
    }

    public Integer pause(Long orderId) {
        // 判断订单状态 - 不能是已完成、已支付、维修结束的
        return updateOrderStatus(orderId, OrderStatus.PAUSED);
    }

    /**
     * 查询分配的订单
     */
    public List<YxxOrder> queryDistributeOrder() {
        YxxWorker worker = workerService.getCurrentWorker();
        return yxxOrderMapper.selectByExample(new YxxOrderExample().createCriteria()
                .andWorkerIdEqualTo(worker.getId()).andOrderStatusEqualTo(OrderStatus.DISTRIBUTED.val())
                .example());
    }

    /**
     * 查询抢单列表
     */
    public List<YxxOrder> queryRushOrder(Integer pageNum, Integer pageSize) {
        // redis 查询rush订单列表
        List<Long> ids = distributorService.getRushOrderIds();
        PageHelper.startPage(pageNum, pageSize);
        return yxxOrderMapper.selectByExample(new YxxOrderExample().createCriteria()
                .andIdIn(ids).andWorkerIdIsNull().andOrderStatusEqualTo(OrderStatus.DISTRIBUTING.val())
                .example());
    }

    public int repairRecordCreate(YxxRepairRecord repairRecord) {
        // 删除原有工单
        repairRecordMapper.deleteByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(repairRecord.getOrderId()).example());
        YxxWorker worker = workerService.getCurrentWorker();
        repairRecord.setWorkerId(worker.getId());
        return repairRecordMapper.insert(repairRecord);
    }

    public YxxRepairRecord repairRecordQuery(Long orderId) {
        return repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example());
    }

    public int repairRecordUpdate(YxxRepairRecord repairRecord) {
        return repairRecordMapper.updateByPrimaryKeySelective(repairRecord);
    }

    public int repairRecordDelete(Long id) {
        return repairRecordMapper.deleteByPrimaryKey(id);
    }

    public int refuse(Long orderId) {
        distributorService.refuse(orderId);
        // workerId 置为空
        return yxxOrderMapper.updateByPrimaryKeySelective(
                YxxOrder.builder().id(orderId).workerId(null).orderStatus(OrderStatus.DISTRIBUTING.val()).updateTime(new Date()).build(),
                YxxOrder.Column.workerId, YxxOrder.Column.orderStatus, YxxOrder.Column.updateTime);
    }
}
