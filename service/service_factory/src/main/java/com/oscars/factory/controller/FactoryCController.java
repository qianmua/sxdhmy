package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.FactoryC;
import com.oscars.factory.service.FactoryCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/factory/factory-c")
@Api("生产厂家")
public class FactoryCController {

    @Autowired
    private FactoryCService factoryCService;

    @ApiOperation("添加生产信息")
    @PutMapping("/add")
    public R addInfo(@RequestBody FactoryC factoryC){
        return factoryCService.save(factoryC) ? R.ok() : R.error();
    }

    @ApiOperation("根据Id查找信息")
    @GetMapping("queryById/{factoryId}")
    public R getById(@PathVariable String factoryId){
        return R.ok().put("info" , factoryCService.getById(factoryId));
    }

    @ApiOperation("条件查询")
    @PostMapping("/queryByCondition/{current}/{limit}")
    public R queryByCondition(@PathVariable long current , @PathVariable long limit){

        return R.ok()
                ;
    }

    @ApiOperation("删除生产信息")
    @DeleteMapping("/deleteById/{factoryId}")
    public R deleteById(@PathVariable String factoryId){
        return factoryCService.removeById(factoryId)
                ? R.ok() : R.error();
    }

    @ApiOperation("修改生产信息")
    @PostMapping("/updateInfo")
    public R updateByInfo(@RequestBody FactoryC factoryC){
        return factoryCService.updateById(factoryC)
                ? R.ok() : R.error();
    }







}

