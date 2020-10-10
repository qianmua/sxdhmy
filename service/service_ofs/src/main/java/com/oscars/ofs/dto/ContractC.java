package com.oscars.ofs.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
@Data
public class ContractC implements Serializable {

    private static final long serialVersionUID=1L;

    private String contractId;

    @TableField("OFFEROR")
    private String offeror;

    @TableField("CONTRACT_NO")
    private String contractNo;

    @TableField("SIGNING_DATE")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date signingDate;

    @TableField("INPUT_BY")
    private String inputBy;

    @TableField("CHECK_BY")
    private String checkBy;

    @TableField("INSPECTOR")
    private String inspector;

    @TableField("TOTAL_AMOUNT")
    private Float totalAmount;

    @TableField("REQUEST")
    private String request;

    @TableField("CUSTOM_NAME")
    private String customName;

    @TableField("SHIP_TIME")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date shipTime;

    @TableField("IMPORT_NUM")
    private Integer importNum;

    @TableField("DELIVERY_PERIOD")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;

    @TableField("REMARK")
    private String remark;

    @TableField("PRINT_STYLE")
    private Integer printStyle;

    @TableField("OLD_STATE")
    private Integer oldState;

    @TableField("STATE")
    private Integer state;

    @TableField("OUT_STATE")
    private Integer outState;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField(value = "CREATE_TIME" , fill = FieldFill.INSERT)
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date createTime;


}
