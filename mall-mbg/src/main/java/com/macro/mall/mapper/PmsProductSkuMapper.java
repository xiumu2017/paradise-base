package com.macro.mall.mapper;

import com.macro.mall.example.PmsProductSkuExample;
import com.macro.mall.model.PmsProductSku;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductSkuMapper {
    long countByExample(PmsProductSkuExample example);

    int deleteByExample(PmsProductSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSku record);

    int insertSelective(@Param("record") PmsProductSku record, @Param("selective") PmsProductSku.Column ... selective);

    PmsProductSku selectOneByExample(PmsProductSkuExample example);

    PmsProductSku selectOneByExampleSelective(@Param("example") PmsProductSkuExample example, @Param("selective") PmsProductSku.Column ... selective);

    List<PmsProductSku> selectByExampleSelective(@Param("example") PmsProductSkuExample example, @Param("selective") PmsProductSku.Column ... selective);

    List<PmsProductSku> selectByExample(PmsProductSkuExample example);

    PmsProductSku selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmsProductSku.Column ... selective);

    PmsProductSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductSku record, @Param("example") PmsProductSkuExample example, @Param("selective") PmsProductSku.Column ... selective);

    int updateByExample(@Param("record") PmsProductSku record, @Param("example") PmsProductSkuExample example);

    int updateByPrimaryKeySelective(@Param("record") PmsProductSku record, @Param("selective") PmsProductSku.Column ... selective);

    int updateByPrimaryKey(PmsProductSku record);

    int batchInsert(@Param("list") List<PmsProductSku> list);

    int batchInsertSelective(@Param("list") List<PmsProductSku> list, @Param("selective") PmsProductSku.Column ... selective);
}