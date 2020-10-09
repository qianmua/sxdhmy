package com.oscars.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  14:22
 * @description :
 */
@Data
@EqualsAndHashCode( callSuper = false)
@ApiModel("合同打印报表")
public class TableExcelModelDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("客户")
    private String customName;

    @ApiModelProperty("订单号")
    private String contractNo;

    @ApiModelProperty("货号")
    private String productNo;

    @ApiModelProperty("数量")
    private String cnumber;

    @ApiModelProperty("工厂")
    private String factory;

    @ApiModelProperty("工厂交期")
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;

    @ApiModelProperty("船期")
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date shipTime;

    @ApiModelProperty("贸易条款")
    private String maoType;








}
