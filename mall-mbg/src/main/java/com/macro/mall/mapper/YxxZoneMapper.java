package com.macro.mall.mapper;

import com.macro.mall.example.YxxZoneExample;
import com.macro.mall.model.YxxZone;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxZoneMapper {
    long countByExample(YxxZoneExample example);

    int deleteByExample(YxxZoneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxZone record);

    int insertSelective(@Param("record") YxxZone record, @Param("selective") YxxZone.Column ... selective);

    YxxZone selectOneByExample(YxxZoneExample example);

    YxxZone selectOneByExampleSelective(@Param("example") YxxZoneExample example, @Param("selective") YxxZone.Column ... selective);

    List<YxxZone> selectByExampleSelective(@Param("example") YxxZoneExample example, @Param("selective") YxxZone.Column ... selective);

    List<YxxZone> selectByExample(YxxZoneExample example);

    YxxZone selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxZone.Column ... selective);

    YxxZone selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxZone record, @Param("example") YxxZoneExample example, @Param("selective") YxxZone.Column ... selective);

    int updateByExample(@Param("record") YxxZone record, @Param("example") YxxZoneExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxZone record, @Param("selective") YxxZone.Column ... selective);

    int updateByPrimaryKey(YxxZone record);

    int batchInsert(@Param("list") List<YxxZone> list);

    int batchInsertSelective(@Param("list") List<YxxZone> list, @Param("selective") YxxZone.Column ... selective);
}