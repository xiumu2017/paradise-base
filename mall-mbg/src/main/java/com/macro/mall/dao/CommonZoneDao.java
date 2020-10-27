package com.macro.mall.dao;

import com.macro.mall.domain.ZoneWorkerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 * @author Paradise
 * @date 2020-10-10
 */
public interface CommonZoneDao {

    /**
     * 查询区域服务中心下的维修工
     *
     * @param zoneId 区域服务中心ID
     * @return {@link ZoneWorkerInfo}
     */
    List<ZoneWorkerInfo> queryWorkersByZoneId(@Param("zoneId") Long zoneId);
}
