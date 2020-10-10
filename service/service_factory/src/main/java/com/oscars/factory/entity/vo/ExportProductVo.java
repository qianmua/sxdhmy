package com.oscars.factory.entity.vo;

import com.oscars.factory.entity.ExportC;
import com.oscars.factory.entity.ExtEproductC;
import lombok.Data;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/10  17:02
 * @description :
 */
@Data
public class ExportProductVo {
    private ExportC exportC;
    private List<ExtEproductC> extEproductCS;

}
