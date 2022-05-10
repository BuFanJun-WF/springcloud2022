package com.wangfan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationConfig
 * @Author wangfan
 * @Date 2022-05-10
 * @Description
 */

@Configuration
public class ApplicationContextBean {

    /**
     * 进行负载均衡，restTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
