package com.macro.mall.mapper;

import com.macro.mall.example.YxxRegionExample;
import com.macro.mall.model.YxxRegion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxRegionMapper {
    long countByExample(YxxRegionExample example);

    int deleteByExample(YxxRegionExample example);

    int deleteByPrimaryKey(Long regionId);

    int insert(YxxRegion record);

    int insertSelective(@Param("record") YxxRegion record, @Param("selective") YxxRegion.Column ... selective);

    YxxRegion selectOneByExample(YxxRegionExample example);

    YxxRegion selectOneByExampleSelective(@Param("example") YxxRegionExample example, @Param("selective") YxxRegion.Column ... selective);

    List<YxxRegion> selectByExampleSelective(@Param("example") YxxRegionExample example, @Param("selective") YxxRegion.Column ... selective);

    List<YxxRegion> selectByExample(YxxRegionExample example);

    YxxRegion selectByPrimaryKeySelective(@Param("regionId") Long regionId, @Param("selective") YxxRegion.Column ... selective);

    YxxRegion selectByPrimaryKey(Long regionId);

    int updateByExampleSelective(@Param("record") YxxRegion record, @Param("example") YxxRegionExample example, @Param("selective") YxxRegion.Column ... selective);

    int updateByExample(@Param("record") YxxRegion record, @Param("example") YxxRegionExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxRegion record, @Param("selective") YxxRegion.Column ... selective);

    int updateByPrimaryKey(YxxRegion record);

    int batchInsert(@Param("list") List<YxxRegion> list);

    int batchInsertSelective(@Param("list") List<YxxRegion> list, @Param("selective") YxxRegion.Column ... selective);
}