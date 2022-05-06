package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderMain80
 * @Author wangfan
 * @Date 2022-05-06
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrderMain80.class, args);
    }
}
