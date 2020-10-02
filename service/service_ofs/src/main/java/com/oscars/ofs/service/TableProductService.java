package com.oscars.ofs.service;

import com.oscars.common.dto.TableExcelModelDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/29  14:54
 * @description :
 */
public interface TableProductService {

    /**
     * 批量插入数据
     * @return row
     */
    Integer saveBatchAll(List<TableExcelModelDto> tableExcelModelDtos);

    List<TableExcelModelDto> getGenDataByDate(String date);
}
