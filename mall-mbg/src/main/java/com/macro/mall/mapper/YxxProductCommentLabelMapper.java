package com.macro.mall.mapper;

import com.macro.mall.example.YxxProductCommentLabelExample;
import com.macro.mall.model.YxxProductCommentLabel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxProductCommentLabelMapper {
    long countByExample(YxxProductCommentLabelExample example);

    int deleteByExample(YxxProductCommentLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxProductCommentLabel record);

    int insertSelective(@Param("record") YxxProductCommentLabel record, @Param("selective") YxxProductCommentLabel.Column ... selective);

    YxxProductCommentLabel selectOneByExample(YxxProductCommentLabelExample example);

    YxxProductCommentLabel selectOneByExampleSelective(@Param("example") YxxProductCommentLabelExample example, @Param("selective") YxxProductCommentLabel.Column ... selective);

    List<YxxProductCommentLabel> selectByExampleSelective(@Param("example") YxxProductCommentLabelExample example, @Param("selective") YxxProductCommentLabel.Column ... selective);

    List<YxxProductCommentLabel> selectByExample(YxxProductCommentLabelExample example);

    YxxProductCommentLabel selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxProductCommentLabel.Column ... selective);

    YxxProductCommentLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxProductCommentLabel record, @Param("example") YxxProductCommentLabelExample example, @Param("selective") YxxProductCommentLabel.Column ... selective);

    int updateByExample(@Param("record") YxxProductCommentLabel record, @Param("example") YxxProductCommentLabelExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxProductCommentLabel record, @Param("selective") YxxProductCommentLabel.Column ... selective);

    int updateByPrimaryKey(YxxProductCommentLabel record);

    int batchInsert(@Param("list") List<YxxProductCommentLabel> list);

    int batchInsertSelective(@Param("list") List<YxxProductCommentLabel> list, @Param("selective") YxxProductCommentLabel.Column ... selective);
}