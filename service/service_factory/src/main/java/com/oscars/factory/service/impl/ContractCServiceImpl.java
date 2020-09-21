package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.PageCondition;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.ContractC;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.entity.vo.ContractItemsVo;
import com.oscars.factory.mapper.ContractCMapper;
import com.oscars.factory.service.ContractCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ContractProductCService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
@Service
public class ContractCServiceImpl extends ServiceImpl<ContractCMapper, ContractC> implements ContractCService {

    @Autowired
    private ContractProductCService contractProductCService;
    @Autowired
    private PageCondition<ContractC> pageCondition1;
    @Autowired
    private PageCondition<ContractProductC> pageCondition2;

    @Override
    @Transactional( rollbackFor = QgbExcaption.class)
    public boolean deleteByIdAndProId(String id) {
        if (StringUtils.isEmpty(id))
            throw new QgbExcaption(20001 , "非法合同id");

        return contractProductCService
                .remove(new LambdaQueryWrapper<ContractProductC>().eq(ContractProductC::getContractId , id))
                &&
                removeById(id);
    }

    @Override
    public Map<String, Object> queryByCondition(long current, long limit, ContractItemsVo contractItemsVo) {
        LambdaQueryWrapper<ContractC> wrapper = new LambdaQueryWrapper<>();
        Page<ContractC> page = new Page<>(current, limit);
        this.baseMapper.selectPage(page , null);
        return pageCondition1.getConditionPageMap(page);
    }
}
