package com.oscars.factory.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.R;
import com.oscars.factory.entity.SysCodeB;
import com.oscars.factory.service.SysCodeBService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/service/factory/sys-code-b")
@Api("分类控制器")
public class SysCodeBController {

    @Autowired
    private SysCodeBService sysCodeBService;

    @ApiOperation("查询所有分类")
    @PostMapping("/queryAll/{current}/{limit}")
    public R queryAll(@PathVariable long current , @PathVariable long limit){

        return R.ok()
                .put("rows" ,sysCodeBService
                        .page(new Page<>(current, limit) , new LambdaQueryWrapper<SysCodeB>().eq(SysCodeB::getParentId , "0104"))
                        .getRecords());
    }

}

