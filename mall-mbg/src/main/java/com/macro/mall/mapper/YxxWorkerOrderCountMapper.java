package com.macro.mall.mapper;

import com.macro.mall.example.YxxWorkerOrderCountExample;
import com.macro.mall.model.YxxWorkerOrderCount;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxWorkerOrderCountMapper {
    long countByExample(YxxWorkerOrderCountExample example);

    int deleteByExample(YxxWorkerOrderCountExample example);

    int deleteByPrimaryKey(Long workerId);

    int insert(YxxWorkerOrderCount record);

    int insertSelective(@Param("record") YxxWorkerOrderCount record, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    YxxWorkerOrderCount selectOneByExample(YxxWorkerOrderCountExample example);

    YxxWorkerOrderCount selectOneByExampleSelective(@Param("example") YxxWorkerOrderCountExample example, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    List<YxxWorkerOrderCount> selectByExampleSelective(@Param("example") YxxWorkerOrderCountExample example, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    List<YxxWorkerOrderCount> selectByExample(YxxWorkerOrderCountExample example);

    YxxWorkerOrderCount selectByPrimaryKeySelective(@Param("workerId") Long workerId, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    YxxWorkerOrderCount selectByPrimaryKey(Long workerId);

    int updateByExampleSelective(@Param("record") YxxWorkerOrderCount record, @Param("example") YxxWorkerOrderCountExample example, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    int updateByExample(@Param("record") YxxWorkerOrderCount record, @Param("example") YxxWorkerOrderCountExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxWorkerOrderCount record, @Param("selective") YxxWorkerOrderCount.Column ... selective);

    int updateByPrimaryKey(YxxWorkerOrderCount record);

    int batchInsert(@Param("list") List<YxxWorkerOrderCount> list);

    int batchInsertSelective(@Param("list") List<YxxWorkerOrderCount> list, @Param("selective") YxxWorkerOrderCount.Column ... selective);
}