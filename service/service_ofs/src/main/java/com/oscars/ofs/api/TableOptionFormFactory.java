package com.oscars.ofs.api;

import com.oscars.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/2  22:14
 * @description :
 */
@FeignClient( value = "sxdhmy-factory")
public interface TableOptionFormFactory {

    /**
     * 远程服务调用
     * @param date
     * @return
     */
    @GetMapping("/service/factory/contract-c/queryTableListByDate")
    R tableList(String date);
}
