package com.oscars.factory.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oscars.factory.entity.ContractProductC;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/22  1:10
 * @description :
 */
@ApiModel("购销合同 条件查询Vo")
@Data
@EqualsAndHashCode( callSuper = false)
public class ContractItemsVo {

    private String offeror;
    private String request;
    private String remark;
    private Integer printStyle;
    private Integer importNum;
    private String contractId;
    private String customName;
    private String contractNo;
    private Integer cnumber;
    private Integer extCnumber;
    private String inputBy;
    private String checkBy;
    private String inspector;
    @JsonFormat( pattern = "yyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date signingDate;
    @JsonFormat( pattern = "yyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date deliveryPeriod;
    @JsonFormat( pattern = "yyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date shipTime;
    private Float amount;
    private Integer state;

    private List<ContractProductCVo> contractProductCS;


}
