package com.oscars.factory.entity.vo;

import com.oscars.factory.entity.ExportC;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/10  20:33
 * @description :
 */
@Data
public class ExportCVo {
    private String exportId;
    private Date inputDate;
    private String contractIds;
    private String customerContract;
    private String lcno;
    private String consignee;
    private String marks;
    private String shipmentPort;
    private String destinationPor;
    private String transportMode;
    private String priceCondition;
    private String remark;
    private Integer boxNum;
    private Integer cnumber;
    private String packingUnit;
    private Float grossWeight;
    private Float netWeight;
    private Float sizeLenght;
    private Float sizeWidth;
    private Float sizeHeight;
    private Float csize;
    private Float amount;
    private Float noTax;
    private Float tax;
    private Float costTax;
    private Integer state;
    private String createBy;
    private String createDept;
    private Date createTime;
    private Integer deletes;
    private Integer number;
    private Integer number2;
}



