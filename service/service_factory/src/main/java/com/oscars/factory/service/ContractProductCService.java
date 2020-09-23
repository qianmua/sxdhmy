package com.oscars.factory.service;

import com.oscars.factory.entity.ContractProductC;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
public interface ContractProductCService extends IService<ContractProductC> {

    List<ContractProductC> queryListByCid(String id, long current, long limit);
}
