package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.MinIoConfiguration;
import com.macro.mall.common.service.impl.MinIoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * MinIO对象存储管理
 *
 * @author macro
 * @date 2019/12/25
 */
@Slf4j
@Api(tags = "图片上传服务")
@RestController
@RequestMapping("/oss")
public class MpController {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @Value("${minio.openUrl}")
    private String openUrl;

    private final MinIoService minIoService;

    public MpController(MinIoService minIoService) {
        this.minIoService = minIoService;
    }

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            MinIoConfiguration configuration = new MinIoConfiguration(endpoint, accessKey, secretKey, bucketName, openUrl);
            return minIoService.upload(file, configuration);
        } catch (Exception e) {
            log.info("上传发生错误: {}！", e.getMessage(), e);
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        return minIoService.delete(objectName, new MinIoConfiguration(endpoint, accessKey, secretKey, bucketName, openUrl));
    }
}
