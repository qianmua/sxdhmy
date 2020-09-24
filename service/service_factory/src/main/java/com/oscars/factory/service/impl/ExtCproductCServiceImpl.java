package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.ExtCproductC;
import com.oscars.factory.mapper.ExtCproductCMapper;
import com.oscars.factory.service.ExtCproductCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
@Service
public class ExtCproductCServiceImpl extends ServiceImpl<ExtCproductCMapper, ExtCproductC> implements ExtCproductCService {

    @Override
    public boolean removeBatch(String cid) {

        if (StringUtils.isBlank(cid))
            throw new QgbExcaption(20003 , "非法合同参数");

        LambdaQueryWrapper<ExtCproductC> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ExtCproductC::getContractProductId , cid);

        return this.remove(wrapper);
    }

    @Override
    public List<ExtCproductC> queryAllByCpId(String id, long current, long limit) {

        Page<ExtCproductC> page = new Page<>(current, limit);
        LambdaQueryWrapper<ExtCproductC> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ExtCproductC::getContractProductId , id);
        this.baseMapper.selectPage(page , wrapper);

        return page.getRecords();
    }
}
