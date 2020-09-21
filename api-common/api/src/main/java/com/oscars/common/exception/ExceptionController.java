package com.oscars.common.exception;

import com.oscars.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/20  21:25
 * @description :
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler( QgbExcaption.class)
    public R failInfo(QgbExcaption e){
        log.error("advice , time{} , info {}", LocalDate.now(), e.getMessage() );
        return R.error(e.getCode() , e.getMsg());
    }
}
