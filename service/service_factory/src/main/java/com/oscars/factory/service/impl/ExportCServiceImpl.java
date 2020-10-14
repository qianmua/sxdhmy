package com.oscars.factory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oscars.common.exception.QgbExcaption;
import com.oscars.factory.entity.*;
import com.oscars.factory.entity.vo.*;
import com.oscars.factory.mapper.ExportCMapper;
import com.oscars.factory.service.ContractCService;
import com.oscars.factory.service.ExportCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ExportProductCService;
import com.oscars.factory.service.ExtEproductCService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qianmuna
 * @since 2020-10-10
 */
@Service
public class ExportCServiceImpl extends ServiceImpl<ExportCMapper, ExportC> implements ExportCService {
    @Autowired
    private ExportProductCService exportProductCService;
    @Autowired
    private ContractCService contractCService;
    @Autowired
    private ExtEproductCService extEproductCService;

    @Override
    @Transactional(rollbackFor = QgbExcaption.class)
    public void updateBatchProduct(ExportProductVo exportProductVo) {
        ExportC exportC = exportProductVo.getExportC();
        this.updateById(exportC);

        List<ExtEproductC> extEproductCS = exportProductVo.getExtEproductCS();
        extEproductCService.updateBatchById(extEproductCS);

    }

    @Override
    public void addExport(String[] ids) {
        ExportC exportC = new ExportC();

        String join = String.join(",", ids);
        exportC.setState(0);

        String[] array = Arrays.stream(ids)
                .map(c -> {
                    ContractC byId = contractCService.getById(c);
                    return byId.getContractNo();
                })
                .toArray(String[]::new);


        String s = String.join(" ", array);
        exportC.setCustomerContract(s);
        exportC.setContractIds(join);
        exportC.setState(0);
        exportC.setDeletes(0);

        this.save(exportC);

        /// item
        Arrays.stream(ids).forEach(v1 -> {
            ContractItemVo itemVo = contractCService.queryItems(v1);
            List<ContractProductitemVo> vos = itemVo.getContractProductC();
            vos.forEach(cpv -> {
                ExportProductC productC1 = new ExportProductC();
                productC1.setExportId(exportC.getExportId());
                BeanUtils.copyProperties(cpv.getContractProductC() , productC1);

                exportProductCService.save(productC1);

                cpv.getExtCproductCS().forEach(ecs ->{
                    ExtEproductC eproductC = new ExtEproductC();
                    eproductC.setExportProductId(productC1.getExportProductId());
                    BeanUtils.copyProperties(ecs , eproductC);

                    extEproductCService.save(eproductC);
                });
            });
        });
    }

    @Override
    public List<ExportCVo> listExport() {
        List<ExportC> list = this.list();
        List<ExportCVo> fl = new ArrayList<>();
        list.forEach(v1 -> {
            ExportCVo cVo = new ExportCVo();

            cVo.setNumber2(0);
            cVo.setNumber(0);


            String id = v1.getExportId();
            int count = exportProductCService
                    .count(new LambdaQueryWrapper<ExportProductC>().eq(ExportProductC::getExportId, id));

            cVo.setNumber(count);
            List<ExportProductC> exportProductCS = exportProductCService
                    .list(new LambdaQueryWrapper<ExportProductC>().eq(ExportProductC::getExportId, id));
            if (!exportProductCS.isEmpty()){
                int sum = exportProductCS.stream().map(ExportProductC::getExportProductId).map(epId ->
                        extEproductCService.count(new LambdaQueryWrapper<ExtEproductC>().eq(ExtEproductC::getExportProductId, epId))
                ).collect(Collectors.toList()).stream().mapToInt(v -> v).sum();
                cVo.setNumber2(sum);

            }

            BeanUtils.copyProperties(v1 , cVo);
            fl.add(cVo);

        });

        return fl;
    }
}
