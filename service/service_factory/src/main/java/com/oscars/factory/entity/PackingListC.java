package com.oscars.factory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
@ApiModel(value="PackingListC对象", description="")
public class PackingListC implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "PACKING_LIST_ID", type = IdType.ASSIGN_ID)
    private String packingListId;

    @TableField("EXPORT_IDS")
    private String exportIds;

    @TableField("SELLER")
    private String seller;

    @TableField("BUYER")
    private String buyer;

    @TableField("INVOICE_NO")
    private String invoiceNo;

    @TableField("INVOICE_DATE")
    private Date invoiceDate;

    @TableField("MARKS")
    private String marks;

    @TableField("DESCRIPTIONS")
    private String descriptions;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField("CREATE_TIME")
    @JsonFormat( pattern = "yyyy-MM-dd")
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date createTime;

    @TableField("EXPORT_NOS")
    private String exportNos;

    @TableField("STATE")
    private Integer state;


}
