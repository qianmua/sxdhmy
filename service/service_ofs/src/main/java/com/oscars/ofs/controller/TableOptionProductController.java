package com.oscars.ofs.controller;

import com.oscars.common.R;
import com.oscars.ofs.service.TableProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  14:56
 * @description :
 */
@Api("option")
@RestController
@RequestMapping("/service/option")
public class TableOptionProductController {

    @Autowired
    private TableProductService tableProductService;

    @ApiOperation("根据出货表生成表格数据")
    @GetMapping("/gen/excel")
    public R gemTable(){
        // date

        return R.ok()
                ;
    }

}
