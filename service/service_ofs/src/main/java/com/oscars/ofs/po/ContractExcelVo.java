package com.oscars.ofs.po;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/10/10  15:46
 * @description :
 */
@Data
@NoArgsConstructor
public class ContractExcelVo {

    /*
    * head
    * */


    @ExcelIgnore
    private String shougou;
    @ExcelIgnore
    private String no;
    @ExcelIgnore
    private Date riqi;
    @ExcelIgnore
    private String factory;
    @ExcelIgnore
    private String man;
    @ExcelIgnore
    private String tel;

    /*
    * footer
    * */

    @ExcelIgnore
    private String zhidan;
    @ExcelIgnore
    private String shendan;
    @ExcelIgnore
    private String yanhuo;
    @ExcelIgnore
    private Double allMoney;


    private String chanpin ;
    private String miaoshi;

    private Integer shuliang;
    private String danwei;

    private Double danjia;

    private Double Alljine;
}
