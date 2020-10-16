package com.macro.mall.mapper;

import com.macro.mall.example.YxxWorkerCertificateExample;
import com.macro.mall.model.YxxWorkerCertificate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxxWorkerCertificateMapper {
    long countByExample(YxxWorkerCertificateExample example);

    int deleteByExample(YxxWorkerCertificateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YxxWorkerCertificate record);

    int insertSelective(@Param("record") YxxWorkerCertificate record, @Param("selective") YxxWorkerCertificate.Column ... selective);

    YxxWorkerCertificate selectOneByExample(YxxWorkerCertificateExample example);

    YxxWorkerCertificate selectOneByExampleSelective(@Param("example") YxxWorkerCertificateExample example, @Param("selective") YxxWorkerCertificate.Column ... selective);

    YxxWorkerCertificate selectOneByExampleWithBLOBs(YxxWorkerCertificateExample example);

    List<YxxWorkerCertificate> selectByExampleSelective(@Param("example") YxxWorkerCertificateExample example, @Param("selective") YxxWorkerCertificate.Column ... selective);

    List<YxxWorkerCertificate> selectByExampleWithBLOBs(YxxWorkerCertificateExample example);

    List<YxxWorkerCertificate> selectByExample(YxxWorkerCertificateExample example);

    YxxWorkerCertificate selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") YxxWorkerCertificate.Column ... selective);

    YxxWorkerCertificate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YxxWorkerCertificate record, @Param("example") YxxWorkerCertificateExample example, @Param("selective") YxxWorkerCertificate.Column ... selective);

    int updateByExampleWithBLOBs(@Param("record") YxxWorkerCertificate record, @Param("example") YxxWorkerCertificateExample example);

    int updateByExample(@Param("record") YxxWorkerCertificate record, @Param("example") YxxWorkerCertificateExample example);

    int updateByPrimaryKeySelective(@Param("record") YxxWorkerCertificate record, @Param("selective") YxxWorkerCertificate.Column ... selective);

    int updateByPrimaryKeyWithBLOBs(YxxWorkerCertificate record);

    int updateByPrimaryKey(YxxWorkerCertificate record);

    int batchInsert(@Param("list") List<YxxWorkerCertificate> list);

    int batchInsertSelective(@Param("list") List<YxxWorkerCertificate> list, @Param("selective") YxxWorkerCertificate.Column ... selective);
}