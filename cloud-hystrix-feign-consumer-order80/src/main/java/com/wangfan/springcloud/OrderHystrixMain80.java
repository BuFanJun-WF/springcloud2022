package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangfan
 * @Description
 * @date 2022/6/13 15:34:45
 */

@SpringBootApplication
@EnableFeignClients // 开启Fegin
@EnableHystrix // 设置开启了hystrix
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
