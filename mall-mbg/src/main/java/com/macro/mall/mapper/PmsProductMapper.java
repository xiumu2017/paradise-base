package com.macro.mall.mapper;

import com.macro.mall.example.PmsProductExample;
import com.macro.mall.model.PmsProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    int insertSelective(@Param("record") PmsProduct record, @Param("selective") PmsProduct.Column ... selective);

    PmsProduct selectOneByExample(PmsProductExample example);

    PmsProduct selectOneByExampleSelective(@Param("example") PmsProductExample example, @Param("selective") PmsProduct.Column ... selective);

    PmsProduct selectOneByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExampleSelective(@Param("example") PmsProductExample example, @Param("selective") PmsProduct.Column ... selective);

    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProduct selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmsProduct.Column ... selective);

    PmsProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example, @Param("selective") PmsProduct.Column ... selective);

    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(@Param("record") PmsProduct record, @Param("selective") PmsProduct.Column ... selective);

    int updateByPrimaryKeyWithBLOBs(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);

    int batchInsert(@Param("list") List<PmsProduct> list);

    int batchInsertSelective(@Param("list") List<PmsProduct> list, @Param("selective") PmsProduct.Column ... selective);
}