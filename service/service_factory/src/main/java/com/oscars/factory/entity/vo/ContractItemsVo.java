package com.oscars.factory.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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

    private String customName;
    private String contractNo;
    private Integer cnumber;
    private String inputBy;
    private String checkBy;
    private String inspector;
    private Date signingDate;
    private Date deliveryPeriod;
    private Date shipTime;
    private Float amount;
    private Integer state;


}
