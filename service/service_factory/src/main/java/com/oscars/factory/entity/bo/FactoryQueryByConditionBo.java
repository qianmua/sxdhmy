package com.oscars.factory.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/20  21:08
 * @description :
 */
@ApiModel("生产家 条件查询构造对象")
@Data
@EqualsAndHashCode( callSuper = false)
public class FactoryQueryByConditionBo {
    @ApiModelProperty(value = "厂家id")
    private String factoryId;
    @ApiModelProperty(value = "厂家全称")
    private String fullName;
    @ApiModelProperty(value = "名称缩写")
    private String factoryName;
    @ApiModelProperty(value = "联系人")
    private String contactor;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "说明")
    private String cnote;
    @ApiModelProperty(value = "类型  SYS_CODE_B 0103")
    private Integer ctype;
    @ApiModelProperty(value = "状态  1正常2停止")
    private String state;
    @ApiModelProperty(value = "排序号")
    private Integer orderNo;
    @ApiModelProperty(value = "开始时间")
    private Date begin;
    @ApiModelProperty(value = "结束时间")
    private Date end;
}
