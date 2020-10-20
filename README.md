

# 德宏贸易管理平台

    包含后端项目 sxdhmy
    前端项目请移步 sxdhmy-admin

## 项目架构

    后端采用 Springboot + SpringCloud2.0 + mysql
    前端使用 Vue2(renren-fast-vue)开源框架
    
    
## 模块

    api-common 基础api  JTW，query封装
    dh-gateway  网关模块
    renren-fast   配套权限管理后台
    service     后台业务模块
        service-factory 工厂模块，合同模块，报运模块，装箱模块，报表模块
        service-ofs    excel文件导出生成模块
        service-Scheduled 定时任务自动化处理模块 
        
        
## 部署 

    采用Docker容器化方式进行部署    
    