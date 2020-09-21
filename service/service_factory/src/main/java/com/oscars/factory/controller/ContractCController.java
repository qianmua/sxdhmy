package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.ContractC;
import com.oscars.factory.entity.vo.ContractItemsVo;
import com.oscars.factory.service.ContractCService;
import com.oscars.factory.service.ContractProductCService;
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
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/service/factory/contract-c")
@Api("购销合同控制器")
public class ContractCController {

    @Autowired
    private ContractCService contractCService;

    @ApiOperation("添加购销合同")
    @PutMapping("/addInfo")
    public R addInfo(@RequestBody ContractC c){

        return R.ok()
                ;
    }

    @ApiOperation("删除购销合同")
    @DeleteMapping("/deleteById/{id}")
    public R deleteById(@PathVariable String id){

        return contractCService.deleteByIdAndProId(id) ?
                R.ok() :
                R.error()
                ;
    }

    @ApiOperation("上报")
    @PostMapping("/updateStatusInfo")
    public R updateStatus(){

        return R.ok();
    }

    @ApiOperation("修改合同")
    @PostMapping("/updateInfo")
    public R updateInfo(){

        return R.ok();
    }

    @ApiOperation("分页条件查询全部购销合同")
    @PostMapping("/queryByCondition/{current}/{limit}")
    public R condition(@PathVariable long current , @PathVariable long limit ,
                       @RequestBody(required = false)ContractItemsVo contractItemsVo){

        return R.ok(contractCService.queryByCondition(current , limit , contractItemsVo));
    }


}

