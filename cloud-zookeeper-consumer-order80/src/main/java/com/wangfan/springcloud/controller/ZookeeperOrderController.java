package com.wangfan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ZookeeperOrderController
 * @Author wangfan
 * @Date 2022-05-06
 * @Description
 */

@RestController
@Slf4j
public class ZookeeperOrderController {
    public static final String INVOKE_URL = "http://cloud-zookeeper-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
