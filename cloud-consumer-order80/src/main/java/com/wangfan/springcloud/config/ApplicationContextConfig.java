package com.wangfan.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

// applicationContext.xml中配置一个依赖注入
// @Bean 相当于 <bean id="" class="">
