package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PaymentMain8001
 * @Author wangfan
 * @Date 2022-05-05
 * @Description 支付服务的启动类
 */

@SpringBootApplication
@EnableEurekaClient // 表示能注册为eurekaClient
@EnableDiscoveryClient // 对于注册进eureka的微服务，可以通过服务发现来获取该服务的信息，也就是通过服务名找到
public class EurekaPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPaymentMain8001.class, args);
    }
}
