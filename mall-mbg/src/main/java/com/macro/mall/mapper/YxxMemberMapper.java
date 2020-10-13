package com.macro.mall.mapper;

import com.macro.mall.example.YxxMemberExample;
import com.macro.mall.model.YxxMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxMemberMapper {
    long countByExample(YxxMemberExample example);

    int deleteByExample(YxxMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxMember record);

    int insertSelective(@Param("record") YxxMember record, @Param("selective") YxxMember.Column ... selective);

    YxxMember selectOneByExample(YxxMemberExample example);

    YxxMember selectOneByExampleSelective(@Param("example") YxxMemberExample example, @Param("selective") YxxMember.Column ... selective);

    List<YxxMember> selectByExampleSelective(@Param("example") YxxMemberExample example, @Param("selective") YxxMember.Column ... selective);

    List<YxxMember> selectByExample(YxxMemberExample example);

    YxxMember selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxMember.Column ... selective);

    YxxMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxMember record, @Param("example") YxxMemberExample example, @Param("selective") YxxMember.Column ... selective);

    int updateByExample(@Param("record") YxxMember record, @Param("example") YxxMemberExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxMember record, @Param("selective") YxxMember.Column ... selective);

    int updateByPrimaryKey(YxxMember record);
}