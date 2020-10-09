package com.oscars.ofs.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  14:22
 * @description :
 */
@Data
@ApiModel("合同打印报表")
@HeadRowHeight(40)
@HeadFontStyle( fontHeightInPoints = 20)
public class TableExcelPo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 40)
    private String customName;
    @ExcelProperty({  "订单号"})
    private String contractNo;

    @ExcelProperty({  "货号"})
    private String productNo;

    @ExcelProperty({ "数量"})
    private String cnumber;

    @ExcelProperty({  "工厂"})
    private String factory;

    @ExcelProperty({ "工厂交期"})
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;

    @ExcelProperty({"船期"})
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date shipTime;

    @ExcelProperty({"贸易条款"})
    private String maoType;








}
