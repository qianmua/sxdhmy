package com.oscars.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/9/21  11:46
 * @description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MemberApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplicationBootstrap.class,args);
    }
}
