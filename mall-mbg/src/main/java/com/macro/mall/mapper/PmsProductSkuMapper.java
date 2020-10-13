package com.macro.mall.mapper;

import com.macro.mall.model.PmsProductSku;
import com.macro.mall.model.PmsProductSkuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductSkuMapper {
    long countByExample(PmsProductSkuExample example);

    int deleteByExample(PmsProductSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSku record);

    int insertSelective(PmsProductSku record);

    List<PmsProductSku> selectByExample(PmsProductSkuExample example);

    PmsProductSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductSku record, @Param("example") PmsProductSkuExample example);

    int updateByExample(@Param("record") PmsProductSku record, @Param("example") PmsProductSkuExample example);

    int updateByPrimaryKeySelective(PmsProductSku record);

    int updateByPrimaryKey(PmsProductSku record);
}