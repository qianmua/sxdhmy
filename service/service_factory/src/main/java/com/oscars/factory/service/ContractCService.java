package com.oscars.factory.service;

import com.oscars.factory.entity.ContractC;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oscars.factory.entity.vo.ContractItemsVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
public interface ContractCService extends IService<ContractC> {

    boolean deleteByIdAndProId(String id);

    Map<String, Object> queryByCondition(long current, long limit, ContractItemsVo contractItemsVo);
}
