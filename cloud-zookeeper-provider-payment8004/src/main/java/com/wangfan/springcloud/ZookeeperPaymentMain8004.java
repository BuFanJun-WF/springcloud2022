package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ZookeeperPaymentMain8004
 * @Author wangfan
 * @Date 2022-05-06
 * @Description 该注解@EnableDiscoveryClient 用于向使用consul或者zookeeper作为注册中心时注册服务
 *
 */

@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class ZookeeperPaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperPaymentMain8004.class, args);
    }
}
