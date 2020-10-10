package com.oscars.factory.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oscars.common.R;
import com.oscars.factory.entity.ExportProductC;
import com.oscars.factory.service.ExportProductCService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianmuna
 * @since 2020-10-10
 */
@RestController
@RequestMapping("/service/factory/export-product-c")
public class ExportProductCController {

    @Autowired
    private ExportProductCService exportProductCService;

    @ApiOperation("list")
    @GetMapping("/list/{id}")
    public R list(@PathVariable String id){
        List<ExportProductC> list = exportProductCService
                .list(new LambdaQueryWrapper<ExportProductC>().eq(ExportProductC::getExportId, id));
        return R.ok()
                .put("rows" , list);
    }


}

