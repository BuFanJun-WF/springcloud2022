package com.wangfan.springcloud;

import com.wangfan.springcloud.config.ApplicationContextConfig;
import com.wangfan.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName MainApp80
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-eureka-payment-service", configuration = MySelfRule.class) // 前面的name表示我要去访问的什么服务
public class EurekaMainApp80 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainApp80.class, args);
    }
}
