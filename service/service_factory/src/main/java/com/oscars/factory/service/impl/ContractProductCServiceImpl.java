package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.mapper.ContractProductCMapper;
import com.oscars.factory.service.ContractProductCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ExtCproductCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ContractProductCServiceImpl extends ServiceImpl<ContractProductCMapper, ContractProductC> implements ContractProductCService {

    @Autowired
    private ExtCproductCService extCproductCService;

    @Override
    public List<ContractProductC> queryListByCid(String id, long current, long limit) {
        Page<ContractProductC> page = new Page<>(current, limit);
        LambdaQueryWrapper<ContractProductC> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ContractProductC::getContractId , id);
        this.baseMapper.selectPage(page , wrapper);

        // list
        return page.getRecords();
    }

    @Override
    @Transactional(rollbackFor = QgbExcaption.class)
    public boolean removeBatch(String id) {
        extCproductCService.removeBatch(id);
        return this.removeById(id);
    }
}
