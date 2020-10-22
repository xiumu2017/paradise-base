package com.macro.mall.mapper;

import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.model.PmsProductCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductCategoryMapper {
    long countByExample(PmsProductCategoryExample example);

    int deleteByExample(PmsProductCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCategory record);

    int insertSelective(@Param("record") PmsProductCategory record, @Param("selective") PmsProductCategory.Column ... selective);

    PmsProductCategory selectOneByExample(PmsProductCategoryExample example);

    PmsProductCategory selectOneByExampleSelective(@Param("example") PmsProductCategoryExample example, @Param("selective") PmsProductCategory.Column ... selective);

    PmsProductCategory selectOneByExampleWithBLOBs(PmsProductCategoryExample example);

    List<PmsProductCategory> selectByExampleSelective(@Param("example") PmsProductCategoryExample example, @Param("selective") PmsProductCategory.Column ... selective);

    List<PmsProductCategory> selectByExampleWithBLOBs(PmsProductCategoryExample example);

    List<PmsProductCategory> selectByExample(PmsProductCategoryExample example);

    PmsProductCategory selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") PmsProductCategory.Column ... selective);

    PmsProductCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example, @Param("selective") PmsProductCategory.Column ... selective);

    int updateByExampleWithBLOBs(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByExample(@Param("record") PmsProductCategory record, @Param("example") PmsProductCategoryExample example);

    int updateByPrimaryKeySelective(@Param("record") PmsProductCategory record, @Param("selective") PmsProductCategory.Column ... selective);

    int updateByPrimaryKeyWithBLOBs(PmsProductCategory record);

    int updateByPrimaryKey(PmsProductCategory record);

    int batchInsert(@Param("list") List<PmsProductCategory> list);

    int batchInsertSelective(@Param("list") List<PmsProductCategory> list, @Param("selective") PmsProductCategory.Column ... selective);
}