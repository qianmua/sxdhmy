package com.oscars.ofs.service;

import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.ofs.dto.ContractItemVo;
import com.oscars.ofs.po.TableExcelPo;

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

    List<TableExcelPo> getGenDataByDate(String date);

    ContractItemVo itemsContractInfo(String id);

}
