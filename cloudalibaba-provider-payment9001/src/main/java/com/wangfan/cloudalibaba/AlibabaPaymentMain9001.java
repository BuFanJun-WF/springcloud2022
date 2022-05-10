package com.wangfan.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName AlibabaPaymentMain9001
 * @Author wangfan
 * @Date 2022-05-08
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9001.class, args);
    }
}
