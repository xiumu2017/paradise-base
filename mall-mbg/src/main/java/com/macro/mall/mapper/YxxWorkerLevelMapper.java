package com.macro.mall.mapper;

import com.macro.mall.example.YxxWorkerLevelExample;
import com.macro.mall.model.YxxWorkerLevel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxWorkerLevelMapper {
    long countByExample(YxxWorkerLevelExample example);

    int deleteByExample(YxxWorkerLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(YxxWorkerLevel record);

    int insertSelective(@Param("record") YxxWorkerLevel record, @Param("selective") YxxWorkerLevel.Column ... selective);

    YxxWorkerLevel selectOneByExample(YxxWorkerLevelExample example);

    YxxWorkerLevel selectOneByExampleSelective(@Param("example") YxxWorkerLevelExample example, @Param("selective") YxxWorkerLevel.Column ... selective);

    List<YxxWorkerLevel> selectByExampleSelective(@Param("example") YxxWorkerLevelExample example, @Param("selective") YxxWorkerLevel.Column ... selective);

    List<YxxWorkerLevel> selectByExample(YxxWorkerLevelExample example);

    YxxWorkerLevel selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") YxxWorkerLevel.Column ... selective);

    YxxWorkerLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") YxxWorkerLevel record, @Param("example") YxxWorkerLevelExample example, @Param("selective") YxxWorkerLevel.Column ... selective);

    int updateByExample(@Param("record") YxxWorkerLevel record, @Param("example") YxxWorkerLevelExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxWorkerLevel record, @Param("selective") YxxWorkerLevel.Column ... selective);

    int updateByPrimaryKey(YxxWorkerLevel record);

    int batchInsert(@Param("list") List<YxxWorkerLevel> list);

    int batchInsertSelective(@Param("list") List<YxxWorkerLevel> list, @Param("selective") YxxWorkerLevel.Column ... selective);
}