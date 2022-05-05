package com.wangfan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName MainApp80
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaMainApp80 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainApp80.class, args);
    }
}
