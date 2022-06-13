package com.wangfan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author wangfan
 * @Date 2022-05-05
 * @Description 测试在配置文件中启动@LoadBalanced注解，给http调用进行负载均衡
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}

// applicationContext.xml中配置一个依赖注入
// @Bean 相当于 <bean id="" class="">
