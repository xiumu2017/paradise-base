package com.macro.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Paradise
 */
@Data
@ApiModel("垚修修维修工信息")
public class YxxWorkerBody {
    @ApiModelProperty(value = "自增主键")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "性别：1男0女")
    private Integer sex;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "状态：1->启用 2->禁用")
    private Integer enable;

    @ApiModelProperty(value = "状态：1->接单中、2->休息中、3->工作中", hidden = true)
    private Integer status;

    @ApiModelProperty(value = "联系地址")
    private String contractAddress;

    @ApiModelProperty(value = "等级", hidden = true)
    private Integer levelId;

    @ApiModelProperty(value = "服务地址")
    private String address;

    @ApiModelProperty(value = "位置坐标")
    private String location;

    @ApiModelProperty(value = "服务分", hidden = true)
    private Integer serviceScore;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "区域ID")
    private Long regionId;

    @ApiModelProperty(value = "区域")
    private String region;

    @ApiModelProperty(value = "区域服务中心ID")
    private Long zoneId;

}
