package com.oscars.ofs.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/10  16:12
 * @description :
 */
public class ContractSheetWriteHandler implements SheetWriteHandler {
    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        Workbook workbook = writeWorkbookHolder.getWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        Row row1 = sheet.createRow(0);
        row1.setHeight((short) 500);
        Cell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("附件2");
        //设置标题
        Row row2 = sheet.createRow(1);
        row2.setHeight((short) 800);
        Cell cell1 = row2.createCell(0);
        cell1.setCellValue("存量建筑垃圾堆体治理进度月报表");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 400);
        cellStyle.setFont(font);
        cell1.setCellStyle(cellStyle);
        sheet.addMergedRegionUnsafe(new CellRangeAddress(1, 1, 0, 17));
        //设置填表日期,填报人,联系方式
        Row row3 = sheet.createRow(2);
        row3.setHeight((short) 500);
        row3.createCell(1).setCellValue("填表日期");
        row3.createCell(11).setCellValue("填表人");
        row3.createCell(15).setCellValue("联系方式");

    }
}
