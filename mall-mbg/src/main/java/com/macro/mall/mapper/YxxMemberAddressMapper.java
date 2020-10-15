package com.macro.mall.mapper;

import com.macro.mall.example.YxxMemberAddressExample;
import com.macro.mall.model.YxxMemberAddress;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxMemberAddressMapper {
    long countByExample(YxxMemberAddressExample example);

    int deleteByExample(YxxMemberAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxMemberAddress record);

    int insertSelective(@Param("record") YxxMemberAddress record, @Param("selective") YxxMemberAddress.Column ... selective);

    YxxMemberAddress selectOneByExample(YxxMemberAddressExample example);

    YxxMemberAddress selectOneByExampleSelective(@Param("example") YxxMemberAddressExample example, @Param("selective") YxxMemberAddress.Column ... selective);

    List<YxxMemberAddress> selectByExampleSelective(@Param("example") YxxMemberAddressExample example, @Param("selective") YxxMemberAddress.Column ... selective);

    List<YxxMemberAddress> selectByExample(YxxMemberAddressExample example);

    YxxMemberAddress selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxMemberAddress.Column ... selective);

    YxxMemberAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxMemberAddress record, @Param("example") YxxMemberAddressExample example, @Param("selective") YxxMemberAddress.Column ... selective);

    int updateByExample(@Param("record") YxxMemberAddress record, @Param("example") YxxMemberAddressExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxMemberAddress record, @Param("selective") YxxMemberAddress.Column ... selective);

    int updateByPrimaryKey(YxxMemberAddress record);
}