package com.oscars.factory.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="FactoryC对象", description="生产家")
public class FactoryC implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "厂家id")
      @TableId(value = "FACTORY_ID", type = IdType.ASSIGN_ID)
    private String factoryId;

    @ApiModelProperty(value = "厂家全称")
    @TableField("FULL_NAME")
    private String fullName;

    @ApiModelProperty(value = "名称缩写")
    @TableField("FACTORY_NAME")
    private String factoryName;

    @ApiModelProperty(value = "联系人")
    @TableField("CONTACTOR")
    private String contactor;

    @ApiModelProperty(value = "电话")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "手机")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "传真")
    @TableField("FAX")
    private String fax;

    @ApiModelProperty(value = "说明")
    @TableField("CNOTE")
    private String cnote;

    @ApiModelProperty(value = "类型  SYS_CODE_B 0103")
    @TableField("CTYPE")
    private Integer ctype;

    @ApiModelProperty(value = "状态  1正常2停止")
    @TableField("STATE")
    private String state;

    @ApiModelProperty(value = "验货员")
    @TableField("INSPECTOR")
    private String inspector;

    @ApiModelProperty(value = "排序号")
    @TableField("ORDER_NO")
    private Integer orderNo;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATE_BY")
    private String createBy;

    @ApiModelProperty(value = "创建部门")
    @TableField("CREATE_DEPT")
    private String createDept;

    @ApiModelProperty(value = "创建日期")
//    @DateTimeFormat
    @JsonFormat( pattern = "yyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME" , fill = FieldFill.INSERT )
    private Date createTime;


}
