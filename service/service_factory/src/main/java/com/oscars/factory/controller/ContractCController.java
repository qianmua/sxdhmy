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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @ApiOperation("根据id查询合同")
    @GetMapping("/queryById/{id}")
    public R queryById(@PathVariable String id){
        return R.ok().put("info" ,contractCService.getById(id));
    }

    @ApiOperation("添加购销合同")
    @PutMapping("/addInfo")
    public R addInfo(@RequestBody ContractC contractC){
        return this.contractCService.save(contractC) ?
                R.ok() : R.error()
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
    public R updateStatus(@RequestBody ContractC contractC){
        return contractCService.updateById(contractC)?
                R.ok() : R.error();
    }

    @ApiOperation("修改合同")
    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody String[] ids){

        return contractCService.updateBatchStatus(Arrays.stream(ids).collect(Collectors.toList()))
                ? R.ok() :R.error();
    }

    @ApiOperation("分页条件查询全部购销合同")
    @PostMapping("/queryByCondition/{current}/{limit}")
    public R condition(@PathVariable long current , @PathVariable long limit ,
                       @RequestBody(required = false)ContractItemsVo contractItemsVo){
        List<ContractItemsVo> itemsVos = contractCService.queryByCondition(current, limit, contractItemsVo);
        return R.ok()
                .put("rows" ,itemsVos );
    }

    @ApiOperation("批量删除合同")
    @PostMapping("/deleteBatch")
    public R rmBatch(@RequestBody String[] ids){

        return contractCService.removeByBatchIds(Arrays.stream(ids).collect(Collectors.toList())) ?
                R.ok() : R.error();
    }


    @ApiOperation("查询合同下 所有货物附件信息")
    @PostMapping("/queryAllInfoByCid/{id}")
    public R queryAllInfoCid(@PathVariable String id){
        return R.ok()
                .put("rows" , contractCService.queryByConditionAll(id));
    }


}

