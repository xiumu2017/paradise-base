package com.macro.mall.mapper;

import com.macro.mall.example.YxxProductChargeStandardExample;
import com.macro.mall.model.YxxProductChargeStandard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxProductChargeStandardMapper {
    long countByExample(YxxProductChargeStandardExample example);

    int deleteByExample(YxxProductChargeStandardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxProductChargeStandard record);

    int insertSelective(@Param("record") YxxProductChargeStandard record, @Param("selective") YxxProductChargeStandard.Column ... selective);

    YxxProductChargeStandard selectOneByExample(YxxProductChargeStandardExample example);

    YxxProductChargeStandard selectOneByExampleSelective(@Param("example") YxxProductChargeStandardExample example, @Param("selective") YxxProductChargeStandard.Column ... selective);

    YxxProductChargeStandard selectOneByExampleWithBLOBs(YxxProductChargeStandardExample example);

    List<YxxProductChargeStandard> selectByExampleSelective(@Param("example") YxxProductChargeStandardExample example, @Param("selective") YxxProductChargeStandard.Column ... selective);

    List<YxxProductChargeStandard> selectByExampleWithBLOBs(YxxProductChargeStandardExample example);

    List<YxxProductChargeStandard> selectByExample(YxxProductChargeStandardExample example);

    YxxProductChargeStandard selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxProductChargeStandard.Column ... selective);

    YxxProductChargeStandard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxProductChargeStandard record, @Param("example") YxxProductChargeStandardExample example, @Param("selective") YxxProductChargeStandard.Column ... selective);

    int updateByExampleWithBLOBs(@Param("record") YxxProductChargeStandard record, @Param("example") YxxProductChargeStandardExample example);

    int updateByExample(@Param("record") YxxProductChargeStandard record, @Param("example") YxxProductChargeStandardExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxProductChargeStandard record, @Param("selective") YxxProductChargeStandard.Column ... selective);

    int updateByPrimaryKeyWithBLOBs(YxxProductChargeStandard record);

    int updateByPrimaryKey(YxxProductChargeStandard record);
}