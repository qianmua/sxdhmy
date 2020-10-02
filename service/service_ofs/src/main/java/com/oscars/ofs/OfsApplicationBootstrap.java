package com.oscars.ofs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/28  22:59
 * @description :
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan( basePackages = {"com.oscars"})
@EnableDiscoveryClient
@EnableFeignClients
public class OfsApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(OfsApplicationBootstrap.class , args);
    }
}
