package com.macro.mall.mapper;

import com.macro.mall.example.YxxHomeBannerExample;
import com.macro.mall.model.YxxHomeBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YxxHomeBannerMapper {
    long countByExample(YxxHomeBannerExample example);

    int deleteByExample(YxxHomeBannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxHomeBanner record);

    int insertSelective(@Param("record") YxxHomeBanner record, @Param("selective") YxxHomeBanner.Column ... selective);

    YxxHomeBanner selectOneByExample(YxxHomeBannerExample example);

    YxxHomeBanner selectOneByExampleSelective(@Param("example") YxxHomeBannerExample example, @Param("selective") YxxHomeBanner.Column ... selective);

    List<YxxHomeBanner> selectByExampleSelective(@Param("example") YxxHomeBannerExample example, @Param("selective") YxxHomeBanner.Column ... selective);

    List<YxxHomeBanner> selectByExample(YxxHomeBannerExample example);

    YxxHomeBanner selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxHomeBanner.Column ... selective);

    YxxHomeBanner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxHomeBanner record, @Param("example") YxxHomeBannerExample example, @Param("selective") YxxHomeBanner.Column ... selective);

    int updateByExample(@Param("record") YxxHomeBanner record, @Param("example") YxxHomeBannerExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxHomeBanner record, @Param("selective") YxxHomeBanner.Column ... selective);

    int updateByPrimaryKey(YxxHomeBanner record);
}