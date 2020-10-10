package com.oscars.ofs.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.oscars.common.R;
import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.ofs.handler.ContractSheetWriteHandler;
import com.oscars.ofs.po.ContractExcelVo;
import com.oscars.ofs.po.TableExcelPo;
import com.oscars.ofs.service.TableProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    public String test(){
        String time = "2020-09-23";
        String s = "G://java_Test//aaa.xlsx";

        EasyExcel.write(s, TableExcelPo.class)
                .autoCloseStream(Boolean.FALSE)
                .head(hand(time))
                .sheet("数据")
                .doWrite(data(time));

        return "success";
    }
    @ApiOperation("打印合同")
    @PostMapping("/gen/contract")
    public void genContract(@RequestBody String time , HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("购销合同打印表", "UTF-8");
        response.setHeader("Content-disposition",  "attachment;filename=" + fileName + ".xlsx");
        //内容样式策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //垂直居中,水平居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        // 字体策略
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //头策略使用默认
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();

        //excel如需下载到本地,只需要将response.getOutputStream()换成File即可(注释掉以上response代码)
        EasyExcel.write(response.getOutputStream(), ContractExcelVo.class)
                //设置输出excel版本,不设置默认为xlsx
                .excelType(ExcelTypeEnum.XLS).head(ContractExcelVo.class)
                //设置拦截器或自定义样式
                .registerWriteHandler(new ContractSheetWriteHandler())
                .registerWriteHandler(new HorizontalCellStyleStrategy(headWriteCellStyle,contentWriteCellStyle))
                .sheet("购销合同")
                //设置默认样式及写入头信息开始的行数
                .useDefaultStyle(true).relativeHeadRowIndex(3)
                //这里的addsumColomn方法是个添加合计的方法,可删除
                .doWrite(data(""));

    }

    @ApiOperation("根据出货表生成表格数据")
    @PostMapping("/gen/excel")
    public void gemTable(@RequestBody String time , HttpServletResponse response){
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("数据", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 这里需要设置不关闭流

            // data

            EasyExcel.write(response.getOutputStream(), TableExcelPo.class)
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
                add(date + "出货表");
                add(baseKeys[finalI]);
            }});
        }
        return lists;
    }

    private List<TableExcelPo> data(String date){
        List<TableExcelPo> list2 = new ArrayList<>();
        // get data
        list2 = tableProductService.getGenDataByDate(date);

        return list2;
    }

}
