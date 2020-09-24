package com.oscars.factory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCodeB对象", description="")
public class SysCodeB implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "SYS_CODE_ID", type = IdType.ASSIGN_ID)
    private String sysCodeId;

    @TableField("NAME")
    private String name;

    @TableField("PARENT_ID")
    private String parentId;

    @TableField("PARENT_NAME")
    private String parentName;

    @TableField("LAYER_NUM")
    private Integer layerNum;

    @TableField("IS_LEAF")
    private Integer isLeaf;

    @TableField("QUOTE_NUM")
    private Integer quoteNum;

    @TableField("CNOTE")
    private String cnote;

    @TableField("ICO")
    private String ico;

    @TableField("ORDER_NO")
    private Integer orderNo;

    @TableField("STATE")
    private String state;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("CREATED_TIME")
    private Date createdTime;

    @TableField("UPDATED_BY")
    private String updatedBy;

    @TableField("UPDATED_TIME")
    private Date updatedTime;


}
