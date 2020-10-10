package com.oscars.factory.service.impl;

import com.oscars.factory.entity.*;
import com.oscars.factory.entity.vo.ContractItemsVo;
import com.oscars.factory.mapper.ExportCMapper;
import com.oscars.factory.service.ContractCService;
import com.oscars.factory.service.ExportCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oscars.factory.service.ExportProductCService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public void addExport(String[] ids) {
        ExportC exportC = new ExportC();

        String join = String.join(" ", ids);
        exportC.setState(0);
        exportC.setCustomerContract(join);
        exportC.setContractIds(join);

        this.save(exportC);

        /// item
        Arrays.stream(ids).forEach(v1 -> {
            ContractItemsVo vo = new ContractItemsVo();
            vo.setContractId(v1);
            List<ContractItemsVo> voList = contractCService.queryByCondition(1, 100, vo);

            voList.forEach(ep ->{
                ExportProductC productC = new ExportProductC();
                productC.setExportId(exportC.getExportId());
                BeanUtils.copyProperties(ep , productC);
                exportProductCService.save(productC);

                ExtEproductC extEproductC = new ExtEproductC();
                BeanUtils.copyProperties(ep , extEproductC);
                extEproductC.setExportProductId(productC.getExportProductId());
            });

        });




    }
}
