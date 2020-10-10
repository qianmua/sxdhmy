package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oscars.common.PageCondition;
import com.oscars.common.dto.TableExcelModelDto;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.ContractC;
import com.oscars.factory.entity.ContractProductC;
import com.oscars.factory.entity.ExportC;
import com.oscars.factory.entity.ExtCproductC;
import com.oscars.factory.entity.vo.ContractItemVo;
import com.oscars.factory.entity.vo.ContractItemsVo;
import com.oscars.factory.entity.vo.ContractProductCVo;
import com.oscars.factory.entity.vo.ContractProductitemVo;
import com.oscars.factory.mapper.ContractCMapper;
import com.oscars.factory.service.ContractCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ContractProductCService;
import com.oscars.factory.service.ExtCproductCService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianmuna
 * @since 2020-09-22
 */
@Service
@Slf4j
public class ContractCServiceImpl extends ServiceImpl<ContractCMapper, ContractC> implements ContractCService {

    @Autowired
    private ContractProductCService contractProductCService;
    @Autowired
    private ExtCproductCService extCproductCService;

    @Autowired
    private ContractCMapper contractCMapper;

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
        LambdaQueryWrapper<ContractC> wrapper = new LambdaQueryWrapper<>();
        String contractId = null;
        if (contractItemsVo != null){
            contractId = contractItemsVo.getContractId();
            if (StringUtils.isNotBlank(contractId))
                wrapper.eq(ContractC::getContractId , contractId);
        }
        this.baseMapper.selectPage(page , wrapper);
        // info
        List<ContractC> records = page.getRecords();

        List<ContractItemsVo> list = new ArrayList<>();
        // queryItems
        Objects.requireNonNull(records).forEach(v1 -> {
            ContractItemsVo vo = new ContractItemsVo();

            vo.setCnumber(0);
            vo.setExtCnumber(0);

            // 合同明细
            List<ContractProductC> byId = contractProductCService
                    .list(new LambdaQueryWrapper<ContractProductC>()
                            .eq(ContractProductC::getContractId , v1.getContractId()));

            int count = contractProductCService.count(new LambdaQueryWrapper<ContractProductC>()
                    .eq(ContractProductC::getContractId, v1.getContractId()));

            double sum2 = byId.stream().map(ContractProductC::getPrice).mapToDouble(sumv -> sumv).sum();

            vo.setCnumber(count);
            vo.setAmount((float) sum2);

//            vo.setContractProductCS(byId);
            List<ContractProductCVo> list2 = new ArrayList<>();

//            ExtCproductC one = null;
            if (!byId.isEmpty()){
                // 合同附件
//                 one = extCproductCService.getOne(new LambdaQueryWrapper<ExtCproductC>()
//                        .select(ExtCproductC::getExtCnumber)
//                        .eq(ExtCproductC::getContractProductId, byId.getContractProductId()));

//                BeanUtils.copyProperties(byId, vo);
//                BeanUtils.copyProperties(one , vo);

                int sum = byId.stream()
                        .peek(vs -> {
                            ContractProductCVo cVo = new ContractProductCVo();
                            cVo.setExtCount(extCproductCService
                                    .count(new LambdaQueryWrapper<ExtCproductC>()
                                    .eq(ExtCproductC::getContractProductId, vs.getContractProductId()))
                            );

                            BeanUtils.copyProperties(vs , cVo);
                            list2.add(cVo);
                        })
                        .map(ContractProductC::getContractProductId)
                        .map(cpId -> extCproductCService.count(new LambdaQueryWrapper<ExtCproductC>()
                                .eq(ExtCproductC::getContractProductId, cpId)))
                        .collect(Collectors.toList())
                        .stream()
                        .mapToInt(value -> value).sum();

//                System.out.println(sum);

                /*int count1 = extCproductCService.count(new LambdaQueryWrapper<ExtCproductC>()
                        .eq(ExtCproductC::getContractProductId, byId.get(0).getContractProductId()));*/

                vo.setExtCnumber(sum);
            }


            vo.setContractProductCS(list2);

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

    @Override
    public ContractItemVo queryItems(String id) {
        // 当前合同
        ContractC byId = this.getById(id);
        // All info
        ContractItemVo vo = new ContractItemVo();
        if (Optional.ofNullable(byId).isPresent()) {
            // 合同下 货物
            List<ContractProductC> list = contractProductCService.list(new LambdaQueryWrapper<ContractProductC>()
                    .eq(ContractProductC::getContractId, byId.getContractId()));

            List<ContractProductitemVo> voCp = new ArrayList<>();

            if (!list.isEmpty()){
                //货物下附件
                list.forEach(v1 -> {
                    List<ExtCproductC> list1 = extCproductCService.list(new LambdaQueryWrapper<ExtCproductC>()
                            .eq(ExtCproductC::getContractProductId, v1.getContractProductId()));

                    voCp.add( new ContractProductitemVo().setContractProductC(v1).setExtCproductCS(list1));
                });
                vo.setContractC(byId).setContractProductC(voCp);
            }
        }

        return vo;
    }

    @Override
    public Object queryByConditionAll(String id) {
        ArrayList<Object> list = new ArrayList<>();
        ContractC byId = this.getById(id);
        if (Optional.ofNullable(byId).isPresent()) {

        }
        return list;
    }

    /**
     * 遍历货物
     * @param id 合同id
     */
    private void getAllCpDataByCid(String id){

    }

    /**
     * 遍历附件
     * @param id 货物id
     */
    private void getAllDataByCpId(String id){

    }

    @Override
    public List<TableExcelModelDto> queryTableList(String date) {
        List<TableExcelModelDto> tablist = contractCMapper.queryTablist(date);
        return tablist;
    }

    @Override
    public void addExport(String[] ids) {

//        String join = String.join(" ", ids);
//        ExportC c = new ExportC();
//        c.setContractIds(join);
//        c.setCustomerContract(join);
//        c.setState(0);

    }
}
