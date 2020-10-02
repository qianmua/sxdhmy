package com.oscars.factory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/20  14:31
 * @description : 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan( basePackages = {"com.oscars" })
@MapperScan( basePackages = {"com.oscars.factory.mapper"})
@EnableFeignClients
public class FactoryApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(FactoryApplicationBootstrap.class , args);
    }
}
