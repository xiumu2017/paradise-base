package com.macro.mall.mapper;

import com.macro.mall.example.YxxHomeCostExample;
import com.macro.mall.model.YxxHomeCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxHomeCostMapper {
    long countByExample(YxxHomeCostExample example);

    int deleteByExample(YxxHomeCostExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxHomeCost record);

    int insertSelective(@Param("record") YxxHomeCost record, @Param("selective") YxxHomeCost.Column ... selective);

    YxxHomeCost selectOneByExample(YxxHomeCostExample example);

    YxxHomeCost selectOneByExampleSelective(@Param("example") YxxHomeCostExample example, @Param("selective") YxxHomeCost.Column ... selective);

    List<YxxHomeCost> selectByExampleSelective(@Param("example") YxxHomeCostExample example, @Param("selective") YxxHomeCost.Column ... selective);

    List<YxxHomeCost> selectByExample(YxxHomeCostExample example);

    YxxHomeCost selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxHomeCost.Column ... selective);

    YxxHomeCost selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxHomeCost record, @Param("example") YxxHomeCostExample example, @Param("selective") YxxHomeCost.Column ... selective);

    int updateByExample(@Param("record") YxxHomeCost record, @Param("example") YxxHomeCostExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxHomeCost record, @Param("selective") YxxHomeCost.Column ... selective);

    int updateByPrimaryKey(YxxHomeCost record);
}