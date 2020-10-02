package com.oscars.ofs.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oscars.common.R;
import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.ofs.api.TableOptionFormFactory;
import com.oscars.ofs.service.TableProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  15:04
 * @description :
 */
@Service
@Slf4j
public class TableProductServiceImpl implements TableProductService {

    @Autowired
    private TableOptionFormFactory tableOptionFormFactory;

    @Override
    public Integer saveBatchAll(List<TableExcelModelDto> tableExcelModelDtos) {

        return null;
    }

    @Override
    public List<TableExcelModelDto> getGenDataByDate(String date) {
        log.info("debug info -> {}" , date);
        R r = tableOptionFormFactory.tableList(date);
        List<TableExcelModelDto> rows = new ArrayList<>();
        try {

//            rows = JSON.toJavaObject(r.get("rows") , List.class) ;
            System.out.println(r.get("rows"));
//            rows = JSONObject.parseArray(r.get("rows") , TableExcelModelDto.class);

        }catch (Exception e){
            log.error("tans err info {}", r.get("rows"));
            return null;
        }

        return rows;
    }
}
