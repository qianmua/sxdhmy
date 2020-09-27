package com.oscars.factory.entity.vo;

import com.oscars.factory.entity.ContractC;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.entity.ExtCproductC;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/27  16:47
 * @description :
 */
@ApiModel("购销合同 详细信息")
@Data
@EqualsAndHashCode( callSuper = false)
@Accessors(chain = true)
public class ContractItemVo {

    private ContractC contractC;
    private List<ContractProductitemVo> contractProductC;

}
