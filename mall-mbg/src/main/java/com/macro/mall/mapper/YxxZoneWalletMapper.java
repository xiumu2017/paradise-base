package com.macro.mall.mapper;

import com.macro.mall.example.YxxZoneWalletExample;
import com.macro.mall.model.YxxZoneWallet;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxZoneWalletMapper {
    long countByExample(YxxZoneWalletExample example);

    int deleteByExample(YxxZoneWalletExample example);

    int deleteByPrimaryKey(Long zoneId);

    int insert(YxxZoneWallet record);

    int insertSelective(@Param("record") YxxZoneWallet record, @Param("selective") YxxZoneWallet.Column ... selective);

    YxxZoneWallet selectOneByExample(YxxZoneWalletExample example);

    YxxZoneWallet selectOneByExampleSelective(@Param("example") YxxZoneWalletExample example, @Param("selective") YxxZoneWallet.Column ... selective);

    List<YxxZoneWallet> selectByExampleSelective(@Param("example") YxxZoneWalletExample example, @Param("selective") YxxZoneWallet.Column ... selective);

    List<YxxZoneWallet> selectByExample(YxxZoneWalletExample example);

    YxxZoneWallet selectByPrimaryKeySelective(@Param("zoneId") Long zoneId, @Param("selective") YxxZoneWallet.Column ... selective);

    YxxZoneWallet selectByPrimaryKey(Long zoneId);

    int updateByExampleSelective(@Param("record") YxxZoneWallet record, @Param("example") YxxZoneWalletExample example, @Param("selective") YxxZoneWallet.Column ... selective);

    int updateByExample(@Param("record") YxxZoneWallet record, @Param("example") YxxZoneWalletExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxZoneWallet record, @Param("selective") YxxZoneWallet.Column ... selective);

    int updateByPrimaryKey(YxxZoneWallet record);

    int batchInsert(@Param("list") List<YxxZoneWallet> list);

    int batchInsertSelective(@Param("list") List<YxxZoneWallet> list, @Param("selective") YxxZoneWallet.Column ... selective);
}