package com.macro.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.service.RedisService;
import com.macro.mall.common.service.impl.DistributorService;
import com.macro.mall.domain.YxxOrderDetail;
import com.macro.mall.enums.OrderStatus;
import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.example.YxxOrderStatusRecordExample;
import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.mapper.YxxMemberMapper;
import com.macro.mall.mapper.YxxOrderMapper;
import com.macro.mall.mapper.YxxOrderStatusRecordMapper;
import com.macro.mall.mapper.YxxRepairRecordMapper;
import com.macro.mall.model.YxxMember;
import com.macro.mall.model.YxxOrder;
import com.macro.mall.model.YxxOrderStatusRecord;
import com.macro.mall.portal.domain.YxxOrderParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.macro.mall.enums.OrderStatus.*;

/**
 * @author Paradise
 */
@Service
public class YxxMpOrderService {

    private final RedisService redisService;
    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    private final YxxOrderMapper yxxOrderMapper;
    private final YxxMemberService memberService;
    private final YxxMemberMapper memberMapper;
    private final YxxRepairRecordMapper repairRecordMapper;
    private final YxxOrderStatusRecordMapper orderStatusRecordMapper;
    private final DistributorService distributorService;

    public YxxMpOrderService(RedisService redisService, YxxOrderMapper yxxOrderMapper,
                             YxxMemberService memberService,
                             YxxMemberMapper memberMapper, YxxRepairRecordMapper repairRecordMapper,
                             YxxOrderStatusRecordMapper orderStatusRecordMapper, DistributorService distributorService) {
        this.redisService = redisService;
        this.yxxOrderMapper = yxxOrderMapper;
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.repairRecordMapper = repairRecordMapper;
        this.orderStatusRecordMapper = orderStatusRecordMapper;
        this.distributorService = distributorService;
    }

    /**
     * 小程序下单
     *
     * @param orderParam 参数
     * @return 返回结果
     */
    public YxxOrder generateOrder(YxxOrderParam orderParam) {
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
        order.setOrderStatus(CREATED.val());
        yxxOrderMapper.insertSelective(order);
        return order;
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
        YxxOrder order = YxxOrder.builder().id(orderId).orderStatus(PAYED.val()).build();
        return yxxOrderMapper.updateByPrimaryKeySelective(order, YxxOrder.Column.orderStatus);
    }

    public int cancelOrder(Long orderId) {
        distributorService.removeFromQueue(orderId);
        return updateOrderStatus(orderId, FREE_CANCEL);
    }

    public YxxOrderDetail detail(Long orderId) {
        YxxOrderDetail detail = new YxxOrderDetail();
        // 订单信息
        detail.setYxxOrder(yxxOrderMapper.selectByPrimaryKey(orderId));
        // 维修工单信息
        detail.setRepairRecord(repairRecordMapper.selectOneByExample(new YxxRepairRecordExample().createCriteria()
                .andOrderIdEqualTo(orderId).example()));
        // 订单状态变更记录
        detail.setOrderStatusRecordList(orderStatusRecordMapper.selectByExample(new YxxOrderStatusRecordExample()
                .createCriteria().andOrderIdEqualTo(orderId).example().orderBy(YxxOrderStatusRecord.Column.createTime.desc())));
        return detail;
    }

    public YxxOrder yxxOrder(Long orderId) {
        return yxxOrderMapper.selectByPrimaryKey(orderId);
    }

    public int deleteOrder(Long orderId) {
        return yxxOrderMapper.deleteByPrimaryKey(orderId);
    }

    public int confirmToVisit(Long orderId) {
        return updateOrderStatus(orderId, WAITED_GET);
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
        return updateOrderStatus(orderId, OFFER_CONFIRMED);
    }

    public int cancelOrderDisagree(Long orderId) {
        return updateOrderStatus(orderId, ARRIVED_CANCEL);
    }

    public CommonPage<YxxOrder> pageQuery(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        YxxMember currentMember = memberService.getCurrentMember();
        YxxOrderExample orderExample = new YxxOrderExample();
        YxxOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        if (status != null) {
            criteria.andOrderStatusIn(Arrays.asList(getOrderStatusArray(status)));
        }
        List<YxxOrder> orderList = yxxOrderMapper.selectByExample(orderExample.orderBy(YxxOrder.Column.createTime.desc()));
        return CommonPage.restPage(orderList);
    }

    private Integer[] getOrderStatusArray(Integer status) {
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
        return new Integer[0];
    }
}
