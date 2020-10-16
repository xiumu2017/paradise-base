package com.macro.mall.mapper;

import com.macro.mall.example.YxxWorkerSkilledProductExample;
import com.macro.mall.model.YxxWorkerSkilledProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxWorkerSkilledProductMapper {
    long countByExample(YxxWorkerSkilledProductExample example);

    int deleteByExample(YxxWorkerSkilledProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxWorkerSkilledProduct record);

    int insertSelective(@Param("record") YxxWorkerSkilledProduct record, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    YxxWorkerSkilledProduct selectOneByExample(YxxWorkerSkilledProductExample example);

    YxxWorkerSkilledProduct selectOneByExampleSelective(@Param("example") YxxWorkerSkilledProductExample example, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    List<YxxWorkerSkilledProduct> selectByExampleSelective(@Param("example") YxxWorkerSkilledProductExample example, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    List<YxxWorkerSkilledProduct> selectByExample(YxxWorkerSkilledProductExample example);

    YxxWorkerSkilledProduct selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    YxxWorkerSkilledProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxWorkerSkilledProduct record, @Param("example") YxxWorkerSkilledProductExample example, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    int updateByExample(@Param("record") YxxWorkerSkilledProduct record, @Param("example") YxxWorkerSkilledProductExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxWorkerSkilledProduct record, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);

    int updateByPrimaryKey(YxxWorkerSkilledProduct record);

    int batchInsert(@Param("list") List<YxxWorkerSkilledProduct> list);

    int batchInsertSelective(@Param("list") List<YxxWorkerSkilledProduct> list, @Param("selective") YxxWorkerSkilledProduct.Column ... selective);
}