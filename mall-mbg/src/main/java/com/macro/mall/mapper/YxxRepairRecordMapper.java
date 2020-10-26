package com.macro.mall.mapper;

import com.macro.mall.example.YxxRepairRecordExample;
import com.macro.mall.model.YxxRepairRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxRepairRecordMapper {
    long countByExample(YxxRepairRecordExample example);

    int deleteByExample(YxxRepairRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxRepairRecord record);

    int insertSelective(@Param("record") YxxRepairRecord record, @Param("selective") YxxRepairRecord.Column ... selective);

    YxxRepairRecord selectOneByExample(YxxRepairRecordExample example);

    YxxRepairRecord selectOneByExampleSelective(@Param("example") YxxRepairRecordExample example, @Param("selective") YxxRepairRecord.Column ... selective);

    List<YxxRepairRecord> selectByExampleSelective(@Param("example") YxxRepairRecordExample example, @Param("selective") YxxRepairRecord.Column ... selective);

    List<YxxRepairRecord> selectByExample(YxxRepairRecordExample example);

    YxxRepairRecord selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxRepairRecord.Column ... selective);

    YxxRepairRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxRepairRecord record, @Param("example") YxxRepairRecordExample example, @Param("selective") YxxRepairRecord.Column ... selective);

    int updateByExample(@Param("record") YxxRepairRecord record, @Param("example") YxxRepairRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxRepairRecord record, @Param("selective") YxxRepairRecord.Column ... selective);

    int updateByPrimaryKey(YxxRepairRecord record);

    int batchInsert(@Param("list") List<YxxRepairRecord> list);

    int batchInsertSelective(@Param("list") List<YxxRepairRecord> list, @Param("selective") YxxRepairRecord.Column ... selective);
}