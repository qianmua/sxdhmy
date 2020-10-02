package com.oscars.factory.mapper;

import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.factory.entity.ContractC;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
public interface ContractCMapper extends BaseMapper<ContractC> {

    /**
     * 查询打印列表
     * @param date
     * @return
     */
    List<TableExcelModelDto> queryTablist(String date);

}
