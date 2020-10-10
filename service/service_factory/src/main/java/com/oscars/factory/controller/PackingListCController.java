package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.PackingListC;
import com.oscars.factory.service.PackingListCService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qianmuna
 * @since 2020-10-10
 */
@RestController
@RequestMapping("/factory/packing-list-c")
public class PackingListCController {

    @Autowired
    private PackingListCService packingListCService;

    @ApiOperation("list")
    @PostMapping("/list")
    public R list(){

        return R.ok().put("rows" , packingListCService.list());
    }

    @ApiOperation("info")
    @GetMapping("/info/{id}")
    public R info(@PathVariable String id){

        return R.ok().put("data" , packingListCService.getById(id));
    }

    @ApiOperation("save")
    @PostMapping("/save")
    public R save(@RequestBody PackingListC packingListC ){
        packingListCService.save(packingListC);
        return R.ok();
    }

    @ApiOperation("update")
    @PutMapping("/update")
    public R update(@RequestBody PackingListC packingListC){
        packingListCService.updateById(packingListC);
        return R.ok();
    }

    @ApiOperation("delete")
    @DeleteMapping("/delete/{id}")
    public R remove(@PathVariable String id){
        packingListCService.removeById(id);
        return R.ok();
    }


}

