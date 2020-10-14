package com.oscars.factory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianmuna
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ExportC对象", description="")
public class ExportC implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "EXPORT_ID", type = IdType.ASSIGN_ID)
    private String exportId;

    @TableField("INPUT_DATE")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date inputDate;

    @TableField("CONTRACT_IDS")
    private String contractIds;

    @TableField("CUSTOMER_CONTRACT")
    private String customerContract;

    @TableField("LCNO")
    private String lcno;

    @TableField("CONSIGNEE")
    private String consignee;

    @TableField("MARKS")
    private String marks;

    @TableField("SHIPMENT_PORT")
    private String shipmentPort;

    @TableField("DESTINATION_POR")
    private String destinationPor;

    @TableField("TRANSPORT_MODE")
    private String transportMode;

    @TableField("PRICE_CONDITION")
    private String priceCondition;

    @TableField("REMARK")
    private String remark;

    @TableField("BOX_NUM")
    private Integer boxNum;

    @TableField("CNUMBER")
    private Integer cnumber;

    @TableField("PACKING_UNIT")
    private String packingUnit;

    @TableField("GROSS_WEIGHT")
    private Float grossWeight;

    @TableField("NET_WEIGHT")
    private Float netWeight;

    @TableField("SIZE_LENGHT")
    private Float sizeLenght;

    @TableField("SIZE_WIDTH")
    private Float sizeWidth;

    @TableField("SIZE_HEIGHT")
    private Float sizeHeight;

    @TableField("CSIZE")
    private Float csize;

    @TableField("AMOUNT")
    private Float amount;

    @TableField("NO_TAX")
    private Float noTax;

    @TableField("TAX")
    private Float tax;

    @TableField("COST_TAX")
    private Float costTax;

    @TableField("STATE")
    private Integer state;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField("CREATE_TIME")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date createTime;

    @TableLogic
    private Integer deletes;


}
