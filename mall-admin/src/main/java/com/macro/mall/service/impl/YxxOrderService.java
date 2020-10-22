package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.dao.YxxOrderDao;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.dto.YxxOrderQueryParam;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxWorkerMapper;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.model.YxxWorker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 *
 * @author Paradise
 * @date 2020-10-10
 */
@Slf4j
@Service
@AllArgsConstructor
public class YxxOrderService {
    private final YxxOrderMapper orderMapper;
    private final YxxOrderStatusRecordMapper statusRecordMapper;
    private final YxxOrderDao yxxOrderDao;
    private final YxxWorkerMapper workerMapper;
    private final DistributorService distributorService;

    public List<YxxOrder> list(YxxOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return yxxOrderDao.getList(queryParam);
    }

    public int delete(List<Long> ids) {
        YxxOrderExample example = new YxxOrderExample();
        example.createCriteria().andIdIn(ids);
        return orderMapper.deleteByExample(example);
    }

    public YxxOrderDetail detail(Long id) {
        return new YxxOrderDetail();
    }


    /**
     * 查询维修工ID列表
     *
     * @param orderId 订单ID
     * @return 加权排序后的维修工列表
     */
    private List<Long> getSortedWorkerIds(Long orderId) {
        // TODO 根据订单品类 关联擅长 查询 符合条件的全部维修工 - 已排序
        YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
        List<YxxWorker> workers = workerMapper.selectByExample(new YxxWorkerExample()
                .createCriteria().andStatusEqualTo(1)
                .example().orderBy(YxxWorker.Column.levelId.desc()));
        return workers.stream().map(YxxWorker::getId).collect(Collectors.toList());
    }

    /**
     * 自动派单
     */
    @Transactional(rollbackFor = Exception.class)
    public void distribute() {
        Long orderId = distributorService.popOrderId();
        if (orderId != null) {
            List<Long> workerIds = getSortedWorkerIds(orderId);
            if (!workerIds.isEmpty()) {
                distributorService.initWorkerQueue(orderId, workerIds);
                // 派发订单
                // 超时计时
                YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
                // 先判断订单状态
                if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
                    distributorService.removeFromQueue(orderId);
                } else {
                    Long workerId = distributorService.popWorkerId(orderId);
                    if (workerId != null) {
                        record(order, OrderStatus.DISTRIBUTED, "已派单-待接单");
                        order.setWorkerId(workerId);
                        order.setOrderStatus(OrderStatus.DISTRIBUTED.val());
                        orderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.workerId, YxxOrder.Column.orderStatus);
                        // 添加到超时等待队列 并设置超时
                        distributorService.addToWaitQueue(orderId, workerId, 30 * 60);
                    } else {
                        // 没有可用的维修工处理
                        log.info("没有可用的维修工处理...");
                    }
                }
            } else {
                // 没有可用的维修工处理
                log.info("没有可用的维修工处理...");
            }
            distribute();
        }
    }

    /**
     * 自动派单
     */
    @Transactional(rollbackFor = Exception.class)
    public void distributeAgain(Long orderId) {
        Long workerId = distributorService.popWorkerId(orderId);
        if (workerId != null) {
            YxxOrder order = orderMapper.selectByPrimaryKey(orderId);
            // 先判断订单状态
            if (order.getOrderStatus() != OrderStatus.DISTRIBUTING.val()) {
                distributorService.removeFromQueue(orderId);
            } else {
                record(order, OrderStatus.DISTRIBUTED, "已派单-待接单");
                order.setWorkerId(workerId);
                order.setOrderStatus(OrderStatus.DISTRIBUTED.val());
                orderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.workerId, YxxOrder.Column.orderStatus);
            }
        } else {
            // 没有可用的维修工处理
            log.info("没有可用的维修工处理...");
        }
    }

    private void record(YxxOrder order, OrderStatus status, String remark) {
        statusRecordMapper.insert(orderBuilder(order.getId(), order.getOrderStatus(), status, remark));
    }

    private void batchRecord(List<Long> ids, OrderStatus status, String remark) {
        List<YxxOrderStatusRecord> recordList = new ArrayList<>();
        ids.forEach(id -> {
            recordList.add(orderBuilder(id, OrderStatus.CREATED.val(), status, remark));
        });
        statusRecordMapper.batchInsert(recordList);
    }

    private YxxOrderStatusRecord orderBuilder(Long orderId, int os, OrderStatus status, String remark) {
        return YxxOrderStatusRecord.builder()
                .remark(remark)
                .orderId(orderId)
                .originStatus(os)
                .currentStatus(status.val())
                .createTime(new Date())
                .build();
    }

    /**
     * 查询新创建的订单 - push 到派单队列
     */
    public void pushQueue() {
        List<YxxOrder> orderList = orderMapper.selectByExample(new YxxOrderExample().createCriteria()
                .andOrderStatusEqualTo(OrderStatus.CREATED.val()).example());
        if (!orderList.isEmpty()) {
            log.info(" push 到派单队列：{}", orderList);
            List<Long> ids = new ArrayList<>();
            orderList.forEach(order -> {
                distributorService.addToQueue(order.getId());
                ids.add(order.getId());
            });
            YxxOrderExample example = new YxxOrderExample().createCriteria().andIdIn(ids).example();
            orderMapper.updateByExampleSelective(YxxOrder.builder().orderStatus(OrderStatus.DISTRIBUTING.val()).updateTime(new Date()).build(),
                    example, YxxOrder.Column.orderStatus, YxxOrder.Column.updateTime);
            this.batchRecord(ids, OrderStatus.DISTRIBUTING, "批量更新订单状态为派单中");
        }
    }
}
