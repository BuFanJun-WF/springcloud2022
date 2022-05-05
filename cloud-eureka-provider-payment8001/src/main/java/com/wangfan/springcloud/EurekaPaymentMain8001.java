package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentMain8001
 * @Author wangfan
 * @Date 2022-05-05
 * @Description 支付服务的启动类
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPaymentMain8001.class, args);
    }
}
