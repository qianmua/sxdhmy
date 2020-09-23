package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.PageCondition;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.ContractC;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.entity.ExtCproductC;
import com.oscars.factory.entity.vo.ContractItemsVo;
import com.oscars.factory.mapper.ContractCMapper;
import com.oscars.factory.service.ContractCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ContractProductCService;
import com.oscars.factory.service.ExtCproductCService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    private ExtCproductCService extCproductCService;

    @Override
    @Transactional( rollbackFor = QgbExcaption.class)
    public boolean deleteByIdAndProId(String id) {
        if (StringUtils.isEmpty(id))
            throw new QgbExcaption(20001 , "非法合同id");
        boolean b = false;
        boolean b1 = false;

        if (null != contractProductCService
                .getOne(new LambdaQueryWrapper<ContractProductC>()
                        .eq(ContractProductC::getContractId, id))){
             b = extCproductCService.remove(new LambdaQueryWrapper<ExtCproductC>()
                    .eq(ExtCproductC::getContractProductId, contractProductCService
                            .getOne(new LambdaQueryWrapper<ContractProductC>()
                                    .eq(ContractProductC::getContractId, id)).getContractProductId()
                    ));
             b1 = contractProductCService.remove(new LambdaQueryWrapper<ContractProductC>()
                    .eq(ContractProductC::getContractId, id));
        }


        boolean b2 = removeById(id);
        return b && b1 && b2;
    }

    @Override
    public List<ContractItemsVo> queryByCondition(long current, long limit, ContractItemsVo contractItemsVo) {

        Page<ContractC> page = new Page<>(current, limit);
        this.baseMapper.selectPage(page , null);

        // info
        List<ContractC> records = page.getRecords();

        List<ContractItemsVo> list = new ArrayList<>();
        // queryItems
        Objects.requireNonNull(records).forEach(v1 -> {
            ContractItemsVo vo = new ContractItemsVo();

            vo.setCnumber(0);
            vo.setExtCnumber(0);

            // 合同明细
            ContractProductC byId = contractProductCService
                    .getOne(new LambdaQueryWrapper<ContractProductC>()
                            .eq(ContractProductC::getContractId , v1.getContractId()));
            int count = contractProductCService.count(new LambdaQueryWrapper<ContractProductC>()
                    .eq(ContractProductC::getContractId, v1.getContractId()));

            vo.setCnumber(count);

//            ExtCproductC one = null;
            if (byId != null){
                // 合同附件
//                 one = extCproductCService.getOne(new LambdaQueryWrapper<ExtCproductC>()
//                        .select(ExtCproductC::getExtCnumber)
//                        .eq(ExtCproductC::getContractProductId, byId.getContractProductId()));

//                BeanUtils.copyProperties(byId, vo);
//                BeanUtils.copyProperties(one , vo);
                int count1 = extCproductCService.count(new LambdaQueryWrapper<ExtCproductC>()
                        .eq(ExtCproductC::getContractProductId, byId.getContractProductId()));

                vo.setExtCnumber(count1);
            }

            BeanUtils.copyProperties(v1 , vo);

            list.add(vo);
        });

        return list;
    }

    @Override
    public boolean removeByBatchIds(List<String> collect) {
        collect.forEach(v1 -> {
            boolean b = this.deleteByIdAndProId(v1);
        });
        return true;
    }

    @Override
    public boolean updateBatchStatus(List<String> collect) {

        List<ContractC> batch = new ArrayList<>();
        collect.forEach(v1 -> batch.add(new ContractC().setContractId(v1).setState(2)));

        return this.updateBatchById(batch);
    }

}
