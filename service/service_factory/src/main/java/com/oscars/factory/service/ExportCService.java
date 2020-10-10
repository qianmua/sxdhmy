package com.oscars.factory.service;

import com.oscars.factory.entity.ExportC;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qianmuna
 * @since 2020-10-10
 */
public interface ExportCService extends IService<ExportC> {

    void addExport(String[] ids);
}
