package com.macro.mall.schedule;

import com.macro.mall.common.service.RedisService;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxWorker;
import com.macro.mall.service.impl.YxxOrderService;
import com.macro.mall.service.impl.YxxWorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 派单逻辑
 *
 * @author Paradise
 */
@Slf4j
@Component
public class Distributor {
    private final String queueKey = "OrderDistributorQueue";
    private final String queueKeyIndexPrefix = "OrderDistributorQueuePrefix";
    private final String counterKey = "CounterKey";
    private final String worksQueueKey = "worksQueueKey";
    private final RedisService redisService;
    private final YxxWorkerService workerService;
    private final YxxOrderService orderService;

    public Distributor(RedisService redisService, YxxWorkerService workerService, YxxOrderService orderService) {
        this.redisService = redisService;
        this.workerService = workerService;
        this.orderService = orderService;
    }
    // 计数器
    // 订单队列 - 待派发订单
    // 订单对应可选维修工列表 - 排序
    // 使用 Redis 来实现

    /**
     * 用户下单 - 添加到派单队列
     *
     * @param order 订单信息
     */
    public void addToQueue(YxxOrder order) {
        Long index = redisService.lPush(queueKey, order);
        redisService.set(queueKeyIndexPrefix + order.getId(), index);
    }

    /**
     * 用户取消 - 从队列移除
     *
     * @param orderId 订单ID
     */
    public void removeFromQueue(Long orderId) {
        String indexKey = queueKeyIndexPrefix + orderId;
        redisService.lRemove(queueKey, (Long) redisService.get(indexKey));
        redisService.del(indexKey);
    }

    private void counterIncr() {
        int value = (int) redisService.get(counterKey);
        if (value > 7) {
            redisService.set(counterKey, 0);
        } else {
            redisService.incr(counterKey, 1);
        }
    }

    @Scheduled(fixedRate = 100_000)
    public void distribute() {
        long size = redisService.lSize(queueKey);
        if (size > 0) {
            log.info("开始派单");
            YxxOrder order = (YxxOrder) redisService.lrPop(queueKey);
            // 根据订单品类 关联擅长 查询 符合条件的全部维修工
            List<YxxWorker> workers = workerService.getAvailableWorkerList(order);
            if (!workers.isEmpty()) {
                redisService.lPushAll(worksQueueKey + order.getId(), workers.toArray(new Object[0]));
                // 派发订单
                orderService.distribute(order, workers.get(0));
            }
        }
    }

    /**
     * 维修工拒绝接单 - 是否需要重新计算权重？
     */
    public void refuse() {

    }

    /**
     * 维修工接单超时
     */
    public void overtime() {

    }
}
