package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.ExtCproductC;
import com.oscars.factory.service.ExtCproductCService;
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
@RequestMapping("/service/factory/ext-cproduct-c")
public class ExtCproductCController {

    @Autowired
    private ExtCproductCService extCproductCService;


    @ApiOperation("添加附件")
    @PostMapping("/addInfo")
    public R addInfo(@RequestBody ExtCproductC extCproductC){
        return extCproductCService.save(extCproductC) ?
                R.ok() : R.error();
    }

    @ApiOperation("修改附件")
    @PutMapping("updateInfo")
    public R updateInfo(@RequestBody ExtCproductC extCproductC){
        return  extCproductCService.updateById(extCproductC)?
                R.ok() : R.error()
                ;
    }

    @ApiOperation("删除附件")
    @DeleteMapping("/deleteById/{id}")
    public R remove(@PathVariable String id){
        return extCproductCService.removeById(id)?
                R.ok() : R.error();
    }

    @ApiOperation("级联删除")
    @PostMapping("/removeAll/{cid}")
    public R removeBatch(@PathVariable String cid){
        return extCproductCService.removeBatch(cid)?
                R.ok() : R.error();
    }

}

