package com.macro.mall.mapper;

import com.macro.mall.example.YxxZoneWorkerExample;
import com.macro.mall.model.YxxZoneWorker;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxZoneWorkerMapper {
    long countByExample(YxxZoneWorkerExample example);

    int deleteByExample(YxxZoneWorkerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxZoneWorker record);

    int insertSelective(@Param("record") YxxZoneWorker record, @Param("selective") YxxZoneWorker.Column ... selective);

    YxxZoneWorker selectOneByExample(YxxZoneWorkerExample example);

    YxxZoneWorker selectOneByExampleSelective(@Param("example") YxxZoneWorkerExample example, @Param("selective") YxxZoneWorker.Column ... selective);

    List<YxxZoneWorker> selectByExampleSelective(@Param("example") YxxZoneWorkerExample example, @Param("selective") YxxZoneWorker.Column ... selective);

    List<YxxZoneWorker> selectByExample(YxxZoneWorkerExample example);

    YxxZoneWorker selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxZoneWorker.Column ... selective);

    YxxZoneWorker selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxZoneWorker record, @Param("example") YxxZoneWorkerExample example, @Param("selective") YxxZoneWorker.Column ... selective);

    int updateByExample(@Param("record") YxxZoneWorker record, @Param("example") YxxZoneWorkerExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxZoneWorker record, @Param("selective") YxxZoneWorker.Column ... selective);

    int updateByPrimaryKey(YxxZoneWorker record);

    int batchInsert(@Param("list") List<YxxZoneWorker> list);

    int batchInsertSelective(@Param("list") List<YxxZoneWorker> list, @Param("selective") YxxZoneWorker.Column ... selective);
}