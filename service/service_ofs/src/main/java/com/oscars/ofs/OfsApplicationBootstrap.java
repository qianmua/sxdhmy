package com.oscars.ofs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/28  22:59
 * @description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OfsApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(OfsApplicationBootstrap.class , args);
    }
}
