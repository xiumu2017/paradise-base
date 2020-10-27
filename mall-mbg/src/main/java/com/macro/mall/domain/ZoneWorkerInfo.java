package com.macro.mall.domain;

import com.macro.mall.model.YxxZoneWorker;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel("区域中心维修工信息")
public class ZoneWorkerInfo extends YxxZoneWorker {
    private String workerName;
    private String workerIcon;
    private String workerTel;
}
