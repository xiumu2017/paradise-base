package com.macro.mall.portal.service.impl;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.mapper.YxxMemberMapper;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.model.YxxMember;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.domain.YxxOrderParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Paradise
 */
@Service
public class YxxOrderService {

    private final RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxMemberService memberService;
    private final YxxMemberMapper memberMapper;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;

    public YxxOrderService(RedisService redisService, YxxOrderMapper yxxOrderMapper,
                           YxxMemberService memberService,
                           YxxMemberMapper memberMapper, YxxOrderStatusRecordMapper orderStatusRecordMapper) {
        this.redisService = redisService;
        this.yxxOrderMapper = yxxOrderMapper;
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.orderStatusRecordMapper = orderStatusRecordMapper;
    }

    /**
     * 小程序下单
     *
     * @param orderParam 参数
     * @return 返回结果
     */
    public Map<String, Object> generateOrder(YxxOrderParam orderParam) {
        YxxMember member = memberService.getCurrentMember();
        long count = yxxOrderMapper.countByExample(new YxxOrderExample().createCriteria()
                .andMemberIdEqualTo(member.getId()).example());
        if (count < 1L) {
            // 第一次 下单 -> 保存更新用户信息 ，地址信息
            member.setPhone(orderParam.getTelephone());
            member.setAddress(orderParam.getAddress());
            member.setSex(orderParam.getSex());
            // 部分更新
            memberMapper.updateByPrimaryKeySelective(member, YxxMember.Column.phone, YxxMember.Column.address, YxxMember.Column.sex);
        }
        // 保存订单信息
        YxxOrder order = orderParam.toOrder();
        order.setOrderSn(generateOrderSn(order));
        order.setMemberId(member.getId());
        order.setMemberName(member.getRealName());
        order.setOrderStatus(OrderStatus.CREATED.val());
        yxxOrderMapper.insertSelective(order);
        return null;
    }

    /**
     * 生成18位订单编号:8位日期 + 2位平台号码 + 2位支付方式 + 6位以上自增id
     */
    private String generateOrderSn(YxxOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incr(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getIsBargain()));
        sb.append(String.format("%02d", order.getIsTransfer()));
        String incrementStr = increment.toString();
        int length = 6;
        if (incrementStr.length() <= length) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
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

    public CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        return null;
    }

    public OmsOrderDetail detail(Long orderId) {
        return null;
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
        orderStatusRecordMapper.insert(
                YxxOrderStatusRecord.builder()
                        .orderId(orderId).originStatus(order.getOrderStatus())
                        .currentStatus(status.val())
                        .build()
        );

        order = YxxOrder.builder().id(orderId).orderStatus(status.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    public int confirmPrice(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.OFFER_CONFIRMED);
    }

    public int cancelOrderDisagree(Long orderId) {
        return updateOrderStatus(orderId, OrderStatus.ARRIVED_CANCEL);
    }
}
