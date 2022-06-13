package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentHystrixMain8001
 * @Author wangfan
 * @Date 2022-05-07
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient // 本服务启动后自动注册到eureka服务中
@EnableCircuitBreaker // 开启Hystrix的注解激活
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
