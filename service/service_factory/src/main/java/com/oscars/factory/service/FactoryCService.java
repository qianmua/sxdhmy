package com.oscars.factory.service;

import com.oscars.factory.entity.FactoryC;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oscars.factory.entity.bo.FactoryQueryByConditionBo;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-20
 */
public interface FactoryCService extends IService<FactoryC> {

    Map<String, Object> queryByCondition(long current, long limit, FactoryQueryByConditionBo factoryQueryByConditionBo);
}
