package com.oscars.ofs.service.impl;

import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.ofs.api.TableOptionFormFactory;
import com.oscars.ofs.po.TableExcelPo;
import com.oscars.ofs.service.TableProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TableExcelPo> getGenDataByDate(String date) {
        log.info("debug info -> {}" , date);
        List<TableExcelPo> pos = tableOptionFormFactory.tableList(date);
        return pos;
    }
}
