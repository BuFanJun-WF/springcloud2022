package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName orderNacosMain80
 * @Author wangfan
 * @Date 2022-05-10
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain80.class, args);
    }
}
