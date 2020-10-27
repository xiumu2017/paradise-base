package com.macro.mall.service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.CommonZoneDao;
import com.macro.mall.domain.ZoneWorkerInfo;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 区域服务中心 通用 service
 *
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class CommonZoneService {
    private final YxxZoneMapper zoneMapper;
    private final YxxZoneApplyMapper zoneApplyMapper;
    private final YxxZoneWorkerMapper zoneWorkerMapper;
    private final YxxZoneWalletMapper zoneWalletMapper;
    private final YxxZoneSkilledProductMapper zoneSkilledProductMapper;
    private final CommonZoneDao commonZoneDao;

    public YxxZone zoneInfo(Long zoneId) {
        return zoneMapper.selectByPrimaryKey(zoneId);
    }

    public List<ZoneWorkerInfo> zoneWorkerInfoList(Long zoneId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commonZoneDao.queryWorkersByZoneId(zoneId);
    }

    /**
     * 维修工申请加入或者创建 区域服务中心
     *
     * @param zoneApply 申请内容
     * @param worker    维修工信息
     * @return result
     */
    public int zoneApply(YxxZoneApply zoneApply, YxxWorker worker) {
        zoneApply.setApplyStatus(0);
        zoneApply.setApplyTime(new Date());
        zoneApply.setRegionId(worker.getRegionId());
        zoneApply.setRegionName(worker.getRegion());
        zoneApply.setWorkerName(worker.getRealName());
        return zoneApplyMapper.insertSelective(zoneApply);
    }

    /**
     * 管理员审核申请
     *
     * @param applyId 区域申请ID
     * @param admin   管理员信息
     * @param result  审核结果
     * @param remark  备注
     * @return result
     */
    public int zoneApplyAudit(Long applyId, UmsAdmin admin, int result, String remark) {
        YxxZoneApply zoneApply = zoneApplyMapper.selectByPrimaryKey(applyId);
        // 审批拒绝
        if (result == 0) {
            zoneApply.setApplyStatus(0);
            zoneApply.setRemark(remark);
            // 时间、管理员信息
            return zoneApplyMapper.updateByPrimaryKeySelective(zoneApply, YxxZoneApply.Column.applyStatus, YxxZoneApply.Column.remark);
        } else {
            // 审批通过
            // 申请创建
            if (zoneApply.getZoneId() == null) {
                YxxZone zone = YxxZone.builder()
                        .createTime(new Date()).cutPercent(new BigDecimal(0)).enable(1)
                        .isManual(0).regionId(zoneApply.getRegionId()).build();
                zoneMapper.insert(zone);
                zoneWorkerMapper.insert(YxxZoneWorker.builder()
                        .isAdmin(1).workerId(zoneApply.getWorkerId()).zoneId(zone.getId()).build());
                zoneWalletMapper.insert(YxxZoneWallet.builder().balance(BigDecimal.ZERO).version(1).zoneId(zone.getId()).build());
            } else {
                // 申请加入
                zoneWorkerMapper.insert(YxxZoneWorker.builder()
                        .isAdmin(0).workerId(zoneApply.getWorkerId()).zoneId(zoneApply.getZoneId()).build());
            }
            zoneApply.setApplyStatus(1);
            zoneApply.setRemark(remark);
            return zoneApplyMapper.updateByPrimaryKeySelective(zoneApply, YxxZoneApply.Column.applyStatus, YxxZoneApply.Column.remark);
        }
    }

}
