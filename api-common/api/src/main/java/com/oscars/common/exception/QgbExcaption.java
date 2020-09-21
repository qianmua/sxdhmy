package com.oscars.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/20  21:20
 * @description :
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors( chain = true)
@AllArgsConstructor
public class QgbExcaption extends RuntimeException {

    private Integer code;
    private String msg;

}
