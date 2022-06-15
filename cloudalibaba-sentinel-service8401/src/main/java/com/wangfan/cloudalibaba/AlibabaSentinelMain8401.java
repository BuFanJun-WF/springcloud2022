package com.wangfan.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName AlibabaSentinelMain8401
 * @Author wangfan
 * @Date 2022-05-12
 * @Description
 */

@SpringBootApplication
// 表示到nacos中注册为客户端
@EnableDiscoveryClient
public class AlibabaSentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelMain8401.class, args);
    }
}
