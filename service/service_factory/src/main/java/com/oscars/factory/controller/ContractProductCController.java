package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.service.ContractProductCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/factory/contract-product-c")
@Api("货物表 ， 商品明细")
public class ContractProductCController {

    @Autowired
    private ContractProductCService contractProductCService;

    @GetMapping("/queryById/{id}")
    @ApiOperation("添加货物信息")
    public R queryById(@PathVariable String id){

        return R.ok()
                .put("info" , contractProductCService.getById(id))
                ;
    }

    @ApiOperation("修改货物信息")
    @PutMapping("/updateInfo")
    public R updateInfo(@RequestBody ContractProductC contractProductC){

        return contractProductCService.updateById(contractProductC) ?
                R.ok() : R.error()
                ;
    }

    @ApiOperation("查询当前订单下所有货物信息")
    @PostMapping("queryAllInfo/{id}/{current}/{limit}")
    public R queryAll(@PathVariable String id ,@PathVariable long current , @PathVariable long limit){
        List<ContractProductC> list = contractProductCService.queryListByCid(id , current , limit);
        return R.ok()
                .put("rows" , list)
                ;
    }

    @ApiOperation("删除货物信息")
    @DeleteMapping("/deleteById/{id}")
    public R deleteInfo(@PathVariable String id){

        return contractProductCService.removeById(id)?
                R.ok() : R.error()
                ;
    }

    @ApiOperation("添加货物")
    @PostMapping("/addInfo")
    public R addInfo(@RequestBody ContractProductC contractProductC){
        return contractProductCService.save(contractProductC)?
                R.ok() :R.error()
                ;
    }

}

