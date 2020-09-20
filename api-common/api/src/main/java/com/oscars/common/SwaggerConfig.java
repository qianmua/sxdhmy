package com.oscars.common;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/8/11  14:32
 * @description :
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket webApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sxdhmy")
                // base info
                .apiInfo(webApiInfo())
                .select()
                // 不显示 此接口文档
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                ;
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("陕西德宏贸易管理平台 API文档")
                .description("接口 测试文档")
                .version("20200920")
                .contact(new Contact("QIANMUA" , "http://gugugua.xyz" , "hjcwyhasgo@163.com"))
                .build()
                ;
    }
}
