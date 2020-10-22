package com.macro.mall.mapper;

import com.macro.mall.example.YxxOrderStatusRecordExample;
import com.macro.mall.model.YxxOrderStatusRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxOrderStatusRecordMapper {
    long countByExample(YxxOrderStatusRecordExample example);

    int deleteByExample(YxxOrderStatusRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxOrderStatusRecord record);

    int insertSelective(@Param("record") YxxOrderStatusRecord record, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    YxxOrderStatusRecord selectOneByExample(YxxOrderStatusRecordExample example);

    YxxOrderStatusRecord selectOneByExampleSelective(@Param("example") YxxOrderStatusRecordExample example, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    List<YxxOrderStatusRecord> selectByExampleSelective(@Param("example") YxxOrderStatusRecordExample example, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    List<YxxOrderStatusRecord> selectByExample(YxxOrderStatusRecordExample example);

    YxxOrderStatusRecord selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    YxxOrderStatusRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxOrderStatusRecord record, @Param("example") YxxOrderStatusRecordExample example, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    int updateByExample(@Param("record") YxxOrderStatusRecord record, @Param("example") YxxOrderStatusRecordExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxOrderStatusRecord record, @Param("selective") YxxOrderStatusRecord.Column ... selective);

    int updateByPrimaryKey(YxxOrderStatusRecord record);

    int batchInsert(@Param("list") List<YxxOrderStatusRecord> list);

    int batchInsertSelective(@Param("list") List<YxxOrderStatusRecord> list, @Param("selective") YxxOrderStatusRecord.Column ... selective);
}