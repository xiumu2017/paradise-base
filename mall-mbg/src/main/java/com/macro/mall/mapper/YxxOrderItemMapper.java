package com.macro.mall.mapper;

import com.macro.mall.example.YxxOrderItemExample;
import com.macro.mall.model.YxxOrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxOrderItemMapper {
    long countByExample(YxxOrderItemExample example);

    int deleteByExample(YxxOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxOrderItem record);

    int insertSelective(@Param("record") YxxOrderItem record, @Param("selective") YxxOrderItem.Column ... selective);

    YxxOrderItem selectOneByExample(YxxOrderItemExample example);

    YxxOrderItem selectOneByExampleSelective(@Param("example") YxxOrderItemExample example, @Param("selective") YxxOrderItem.Column ... selective);

    List<YxxOrderItem> selectByExampleSelective(@Param("example") YxxOrderItemExample example, @Param("selective") YxxOrderItem.Column ... selective);

    List<YxxOrderItem> selectByExample(YxxOrderItemExample example);

    YxxOrderItem selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxOrderItem.Column ... selective);

    YxxOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxOrderItem record, @Param("example") YxxOrderItemExample example, @Param("selective") YxxOrderItem.Column ... selective);

    int updateByExample(@Param("record") YxxOrderItem record, @Param("example") YxxOrderItemExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxOrderItem record, @Param("selective") YxxOrderItem.Column ... selective);

    int updateByPrimaryKey(YxxOrderItem record);

    int batchInsert(@Param("list") List<YxxOrderItem> list);

    int batchInsertSelective(@Param("list") List<YxxOrderItem> list, @Param("selective") YxxOrderItem.Column ... selective);
}