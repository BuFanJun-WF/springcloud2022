package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName GateWayMain9527
 * @Author wangfan
 * @Date 2022-05-08
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient // 作为客户端向eureka注册
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
