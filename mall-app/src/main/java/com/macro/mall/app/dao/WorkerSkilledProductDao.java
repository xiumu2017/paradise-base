package com.macro.mall.app.dao;

import com.macro.mall.app.domain.WorkerSkilledProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 擅长品类
 *
 * @author Paradise
 * @date 2020-10-16
 */
public interface WorkerSkilledProductDao {

    /**
     * 查询擅长服务品类列表
     *
     * @param workerId 维修工ID
     * @return 擅长服务品类列表
     */
    List<WorkerSkilledProductInfo> list(@Param("workerId") Long workerId);
}
