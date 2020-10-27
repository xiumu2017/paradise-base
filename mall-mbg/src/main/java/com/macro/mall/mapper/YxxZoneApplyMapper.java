package com.macro.mall.mapper;

import com.macro.mall.example.YxxZoneApplyExample;
import com.macro.mall.model.YxxZoneApply;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxZoneApplyMapper {
    long countByExample(YxxZoneApplyExample example);

    int deleteByExample(YxxZoneApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxZoneApply record);

    int insertSelective(@Param("record") YxxZoneApply record, @Param("selective") YxxZoneApply.Column ... selective);

    YxxZoneApply selectOneByExample(YxxZoneApplyExample example);

    YxxZoneApply selectOneByExampleSelective(@Param("example") YxxZoneApplyExample example, @Param("selective") YxxZoneApply.Column ... selective);

    List<YxxZoneApply> selectByExampleSelective(@Param("example") YxxZoneApplyExample example, @Param("selective") YxxZoneApply.Column ... selective);

    List<YxxZoneApply> selectByExample(YxxZoneApplyExample example);

    YxxZoneApply selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxZoneApply.Column ... selective);

    YxxZoneApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxZoneApply record, @Param("example") YxxZoneApplyExample example, @Param("selective") YxxZoneApply.Column ... selective);

    int updateByExample(@Param("record") YxxZoneApply record, @Param("example") YxxZoneApplyExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxZoneApply record, @Param("selective") YxxZoneApply.Column ... selective);

    int updateByPrimaryKey(YxxZoneApply record);

    int batchInsert(@Param("list") List<YxxZoneApply> list);

    int batchInsertSelective(@Param("list") List<YxxZoneApply> list, @Param("selective") YxxZoneApply.Column ... selective);
}