package com.macro.mall.mapper;

import com.macro.mall.example.YxxZoneSkilledProductExample;
import com.macro.mall.model.YxxZoneSkilledProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxZoneSkilledProductMapper {
    long countByExample(YxxZoneSkilledProductExample example);

    int deleteByExample(YxxZoneSkilledProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxZoneSkilledProduct record);

    int insertSelective(@Param("record") YxxZoneSkilledProduct record, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    YxxZoneSkilledProduct selectOneByExample(YxxZoneSkilledProductExample example);

    YxxZoneSkilledProduct selectOneByExampleSelective(@Param("example") YxxZoneSkilledProductExample example, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    List<YxxZoneSkilledProduct> selectByExampleSelective(@Param("example") YxxZoneSkilledProductExample example, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    List<YxxZoneSkilledProduct> selectByExample(YxxZoneSkilledProductExample example);

    YxxZoneSkilledProduct selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    YxxZoneSkilledProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxZoneSkilledProduct record, @Param("example") YxxZoneSkilledProductExample example, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    int updateByExample(@Param("record") YxxZoneSkilledProduct record, @Param("example") YxxZoneSkilledProductExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxZoneSkilledProduct record, @Param("selective") YxxZoneSkilledProduct.Column ... selective);

    int updateByPrimaryKey(YxxZoneSkilledProduct record);

    int batchInsert(@Param("list") List<YxxZoneSkilledProduct> list);

    int batchInsertSelective(@Param("list") List<YxxZoneSkilledProduct> list, @Param("selective") YxxZoneSkilledProduct.Column ... selective);
}