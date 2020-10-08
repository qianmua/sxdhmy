package com.oscars.ofs.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.oscars.common.R;
import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.ofs.service.TableProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  14:56
 * @description :
 */
@Api("option")
@RestController
@RequestMapping("/ofs/table/option")
public class TableOptionProductController {

    @Autowired
    private TableProductService tableProductService;

    @GetMapping("/test")
    public List<TableExcelModelDto> test(String time){
        List<TableExcelModelDto> dataByDate = tableProductService.getGenDataByDate(time);
        return dataByDate;
    }

    @ApiOperation("根据出货表生成表格数据")
    @GetMapping("/gen/excel")
    public void gemTable(String time , HttpServletResponse response){
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("数据", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 这里需要设置不关闭流

            // data

            EasyExcel.write(response.getOutputStream(), TableExcelModelDto.class)
                    .autoCloseStream(Boolean.FALSE)
                    .head(hand(time))
                    .sheet("数据")
                    .doWrite(data(time));

        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            try {
                response.getWriter().println(JSON.toJSONString(R.error("下载文件失败" + e.getMessage())));
            } catch (IOException ex) {
                e.printStackTrace();
            }
        }
    }

    private List<List<String>> hand(String date){
        List<List<String>> lists = new ArrayList<>();

        final int BASE_VALUE = 8;
        String[] baseKeys = {"客户" , "订单号" , "货号" , "数量" , "工厂" , "工厂交期" , "船期" ,"贸易条款" };
        for (int i = 0; i < BASE_VALUE; i++) {

            int finalI = i;
            lists.add(new ArrayList<String>(){{
                add(date);
                add(baseKeys[finalI]);
            }});
        }



        return lists;
    }

    private List<TableExcelModelDto> data(String date){
        List<TableExcelModelDto> list = new ArrayList<>();

        // get data
        list = tableProductService.getGenDataByDate(date);

        return list;
    }

}
