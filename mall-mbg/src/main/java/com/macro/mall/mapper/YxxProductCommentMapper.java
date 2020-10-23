package com.macro.mall.mapper;

import com.macro.mall.example.YxxProductCommentExample;
import com.macro.mall.model.YxxProductComment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxProductCommentMapper {
    long countByExample(YxxProductCommentExample example);

    int deleteByExample(YxxProductCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxProductComment record);

    int insertSelective(@Param("record") YxxProductComment record, @Param("selective") YxxProductComment.Column ... selective);

    YxxProductComment selectOneByExample(YxxProductCommentExample example);

    YxxProductComment selectOneByExampleSelective(@Param("example") YxxProductCommentExample example, @Param("selective") YxxProductComment.Column ... selective);

    List<YxxProductComment> selectByExampleSelective(@Param("example") YxxProductCommentExample example, @Param("selective") YxxProductComment.Column ... selective);

    List<YxxProductComment> selectByExample(YxxProductCommentExample example);

    YxxProductComment selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxProductComment.Column ... selective);

    YxxProductComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxProductComment record, @Param("example") YxxProductCommentExample example, @Param("selective") YxxProductComment.Column ... selective);

    int updateByExample(@Param("record") YxxProductComment record, @Param("example") YxxProductCommentExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxProductComment record, @Param("selective") YxxProductComment.Column ... selective);

    int updateByPrimaryKey(YxxProductComment record);

    int batchInsert(@Param("list") List<YxxProductComment> list);

    int batchInsertSelective(@Param("list") List<YxxProductComment> list, @Param("selective") YxxProductComment.Column ... selective);
}