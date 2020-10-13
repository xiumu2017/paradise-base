package com.macro.mall.mapper;

import com.macro.mall.example.YxxHomeQaExample;
import com.macro.mall.model.YxxHomeQa;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxHomeQaMapper {
    long countByExample(YxxHomeQaExample example);

    int deleteByExample(YxxHomeQaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxHomeQa record);

    int insertSelective(@Param("record") YxxHomeQa record, @Param("selective") YxxHomeQa.Column ... selective);

    YxxHomeQa selectOneByExample(YxxHomeQaExample example);

    YxxHomeQa selectOneByExampleSelective(@Param("example") YxxHomeQaExample example, @Param("selective") YxxHomeQa.Column ... selective);

    List<YxxHomeQa> selectByExampleSelective(@Param("example") YxxHomeQaExample example, @Param("selective") YxxHomeQa.Column ... selective);

    List<YxxHomeQa> selectByExample(YxxHomeQaExample example);

    YxxHomeQa selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxHomeQa.Column ... selective);

    YxxHomeQa selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxHomeQa record, @Param("example") YxxHomeQaExample example, @Param("selective") YxxHomeQa.Column ... selective);

    int updateByExample(@Param("record") YxxHomeQa record, @Param("example") YxxHomeQaExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxHomeQa record, @Param("selective") YxxHomeQa.Column ... selective);

    int updateByPrimaryKey(YxxHomeQa record);
}