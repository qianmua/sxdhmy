package com.oscars.ofs.api;

import com.oscars.common.R;
import com.oscars.ofs.dto.ContractItemVo;
import com.oscars.ofs.po.TableExcelPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/2  22:14
 * @description :
 */
@FeignClient( value = "sxdhmy-factory")
@Component
public interface TableOptionFormFactory {

    /**
     * 远程服务调用
     *  货物信息
     * @param date
     * @return
     */
    @GetMapping("/service/factory/contract-c/queryTableListByDate")
    List<TableExcelPo> tableList(@RequestParam("time") String date);

    /**
     * 购销合同信息
     * @param id
     * @return
     */
    @PostMapping("/service/factory/contract-c/queryItemByTime")
    ContractItemVo itemsContractInfo(@RequestParam("id") String id);

}