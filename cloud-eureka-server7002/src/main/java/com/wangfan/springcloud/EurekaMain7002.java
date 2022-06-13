package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaMain
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@SpringBootApplication
@EnableEurekaServer // 表示启动后作为eurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
