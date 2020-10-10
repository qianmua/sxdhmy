package com.oscars.factory.controller;


import com.oscars.common.R;
import com.oscars.factory.entity.ExportC;
import com.oscars.factory.entity.vo.ExportCVo;
import com.oscars.factory.entity.vo.ExportProductVo;
import com.oscars.factory.service.ExportCService;
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
 * @since 2020-10-10
 */
@RestController
@RequestMapping("/service/factory/export-c")
public class ExportCController {

    @Autowired
    private ExportCService exportCService;

    @ApiOperation("新增")
    @PostMapping("/save")
    public R save(@RequestBody String[] ids){
        exportCService.addExport(ids);

        return R.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id){
        exportCService.removeById(id);
        return R.ok();
    }

    @ApiOperation("修改")
    @PutMapping("/update")
    public R update(@RequestBody ExportProductVo exportProductVo){
        exportCService.updateBatchProduct(exportProductVo);
        return R.ok();
    }

    @ApiOperation("列表")
    @PostMapping("/list")
    public R list(){
        List<ExportCVo> page = exportCService.listExport();
        return R.ok()
                .put("rows" , page);
    }

    @ApiOperation("info")
    @GetMapping("/info/{id}")
    public R info(@PathVariable String id){
        exportCService.getById(id);

        return R.ok();
    }

}

