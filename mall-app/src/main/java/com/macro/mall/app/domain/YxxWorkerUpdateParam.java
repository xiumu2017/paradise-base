package com.macro.mall.app.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Paradise
 */
@ApiModel(value = "垚修修维修工信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YxxWorkerUpdateParam {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "性别：1男0女")
    private Integer sex;

    @ApiModelProperty(value = "联系地址")
    private String contractAddress;

    @ApiModelProperty(value = "服务地址")
    private String address;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "区域ID")
    private Long regionId;

    @ApiModelProperty(value = "身份证号码")
    private String idNo;

    @ApiModelProperty(value = "身份证照片")
    private String idPhoto;

}
