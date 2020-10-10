package com.oscars.factory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="ExportProductC对象", description="")
public class ExportProductC implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "EXPORT_PRODUCT_ID", type = IdType.ASSIGN_ID)
    private String exportProductId;

    @TableField("CONTRACT_PRODUCT_ID")
    private String contractProductId;

    @TableField("EXPORT_ID")
    private String exportId;

    @TableField("FACTORY_ID")
    private String factoryId;

    @TableField("CONTRACT_ID")
    private String contractId;

    @TableField("CONTRACT_NO")
    private String contractNo;

    @TableField("PRODUCT_NAME")
    private String productName;

    @TableField("PRODUCT_NO")
    private String productNo;

    @TableField("PRODUCT_IMAGE")
    private String productImage;

    @TableField("PRODUCT_DESC")
    private String productDesc;

    @TableField("LOADING_RATE")
    private String loadingRate;

    @TableField("PACKING_UNIT")
    private String packingUnit;

    @TableField("CNUMBER")
    private Integer cnumber;

    @TableField("OUT_NUMBER")
    private Integer outNumber;

    @TableField("FINISHED")
    private Integer finished;

    @TableField("GROSS_WEIGHT")
    private Float grossWeight;

    @TableField("NET_WEIGHT")
    private Float netWeight;

    @TableField("SIZE_WIDTH")
    private Float sizeWidth;

    @TableField("SIZE_HEIGHT")
    private Float sizeHeight;

    @TableField("PRODUCT_REQUEST")
    private String productRequest;

    @TableField("FACTORY")
    private String factory;

    @TableField("PRICE")
    private Float price;

    @TableField("AMOUNT")
    private Float amount;

    @TableField("CUNIT")
    private String cunit;

    @TableField("BOX_NUM")
    private Integer boxNum;

    @TableField("EX_PRICE")
    private Float exPrice;

    @TableField("EX_UNIT")
    private String exUnit;

    @TableField("NO_TAX")
    private Float noTax;

    @TableField("TAX")
    private Float tax;

    @TableField("COST_PRICE")
    private Float costPrice;

    @TableField("COST_TAX")
    private Float costTax;

    @TableField("ACCESSORIES")
    private Integer accessories;

    @TableField("ORDER_NO")
    private Integer orderNo;


}
