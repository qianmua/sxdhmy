package com.oscars.ofs.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
public class TableExcelPo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customName;

    private String contractNo;

    private String productNo;

    private String cnumber;

    private String factory;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;

    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date shipTime;

    private String maoType;








}
