package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.PageCondition;
import com.oscars.factory.entity.FactoryC;
import com.oscars.factory.entity.bo.FactoryQueryByConditionBo;
import com.oscars.factory.mapper.FactoryCMapper;
import com.oscars.factory.service.FactoryCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-20
 */
@Service
public class FactoryCServiceImpl extends ServiceImpl<FactoryCMapper, FactoryC> implements FactoryCService {

    @Autowired
    private PageCondition<FactoryC> pageCondition;

    @Override
    public Map<String, Object> queryByCondition(long current, long limit, FactoryQueryByConditionBo factoryQueryByConditionBo) {
        Page<FactoryC> page = new Page<>(current, limit);
        LambdaQueryWrapper<FactoryC> wrapper = new LambdaQueryWrapper<>();
        Optional<FactoryQueryByConditionBo> bo = Optional.ofNullable(factoryQueryByConditionBo);

        if (bo.isPresent() && bo.get().getFactoryId() != null)
            wrapper.eq(FactoryC::getFactoryId , bo.get().getFactoryId());
        if (bo.isPresent() && bo.get().getOrderNo() != null)
            wrapper.eq(FactoryC::getOrderNo , bo.get().getOrderNo());
        if (bo.isPresent() && bo.get().getBegin() != null)
            wrapper.ge(FactoryC::getCreateTime , bo.get().getBegin());
        if (bo.isPresent() && bo.get().getCnote() != null)
            wrapper.like(FactoryC::getCnote , bo.get().getCnote());
        if (bo.isPresent() && bo.get().getContactor() != null)
            wrapper.like(FactoryC::getContactor , bo.get().getContactor());
        if (bo.isPresent() && bo.get().getCtype() != null)
            wrapper.like(FactoryC::getCtype , bo.get().getCtype());
        if (bo.isPresent() && bo.get().getEnd() != null)
            wrapper.le(FactoryC::getCreateTime , bo.get().getEnd());
        if (bo.isPresent() && bo.get().getFactoryName() != null)
            wrapper.like(FactoryC::getFactoryName , bo.get().getFactoryName());
        if (bo.isPresent() && bo.get().getPhone() != null)
            wrapper.eq(FactoryC::getPhone , bo.get().getPhone());
        if (bo.isPresent() && bo.get().getState() != null)
            wrapper.eq(FactoryC::getState , bo.get().getState());

        this.baseMapper.selectPage(page , wrapper);

        return pageCondition.getConditionPageMap(page);
    }
}
