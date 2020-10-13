package com.macro.mall.mapper;

import com.macro.mall.example.YxxWorkerExample;
import com.macro.mall.model.YxxWorker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxWorkerMapper {
    long countByExample(YxxWorkerExample example);

    int deleteByExample(YxxWorkerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxWorker record);

    int insertSelective(@Param("record") YxxWorker record, @Param("selective") YxxWorker.Column ... selective);

    YxxWorker selectOneByExample(YxxWorkerExample example);

    YxxWorker selectOneByExampleSelective(@Param("example") YxxWorkerExample example, @Param("selective") YxxWorker.Column ... selective);

    List<YxxWorker> selectByExampleSelective(@Param("example") YxxWorkerExample example, @Param("selective") YxxWorker.Column ... selective);

    List<YxxWorker> selectByExample(YxxWorkerExample example);

    YxxWorker selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxWorker.Column ... selective);

    YxxWorker selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxWorker record, @Param("example") YxxWorkerExample example, @Param("selective") YxxWorker.Column ... selective);

    int updateByExample(@Param("record") YxxWorker record, @Param("example") YxxWorkerExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxWorker record, @Param("selective") YxxWorker.Column ... selective);

    int updateByPrimaryKey(YxxWorker record);
}