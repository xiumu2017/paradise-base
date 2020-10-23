package com.macro.mall.mapper;

import com.macro.mall.example.YxxOrderExample;
import com.macro.mall.model.YxxOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxOrderMapper {
    long countByExample(YxxOrderExample example);

    int deleteByExample(YxxOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxOrder record);

    int insertSelective(@Param("record") YxxOrder record, @Param("selective") YxxOrder.Column ... selective);

    YxxOrder selectOneByExample(YxxOrderExample example);

    YxxOrder selectOneByExampleSelective(@Param("example") YxxOrderExample example, @Param("selective") YxxOrder.Column ... selective);

    List<YxxOrder> selectByExampleSelective(@Param("example") YxxOrderExample example, @Param("selective") YxxOrder.Column ... selective);

    List<YxxOrder> selectByExample(YxxOrderExample example);

    YxxOrder selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxOrder.Column ... selective);

    YxxOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxOrder record, @Param("example") YxxOrderExample example, @Param("selective") YxxOrder.Column ... selective);

    int updateByExample(@Param("record") YxxOrder record, @Param("example") YxxOrderExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxOrder record, @Param("selective") YxxOrder.Column ... selective);

    int updateByPrimaryKey(YxxOrder record);

    int batchInsert(@Param("list") List<YxxOrder> list);

    int batchInsertSelective(@Param("list") List<YxxOrder> list, @Param("selective") YxxOrder.Column ... selective);
}