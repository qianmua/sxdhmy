package com.oscars.factory.service;

import com.oscars.factory.entity.ExtCproductC;
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
public interface ExtCproductCService extends IService<ExtCproductC> {

    boolean removeBatch(String cid);

    List<ExtCproductC> queryAllByCpId(String id, long current, long limit);
}
