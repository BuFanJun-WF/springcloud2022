package com.wangfan.springcloud.controller;

import com.wangfan.springcloud.entities.CommonResult;
import com.wangfan.springcloud.entities.Payment;
import com.wangfan.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName OrderController
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@RestController
@Slf4j
public class OrderController {

    // 这个写死服务的端口
    // public static final String PAYMENT_URL = "http://localhost:8001";

    // 通过在eureka上注册过的微服务名称调用
    public static final String PAYMENT_URL = "http://cloud-eureka-payment-service";

    @Resource
    private RestTemplate restTemplate;

    // 可以获取注册中心上的服务列表
    @Resource
    private DiscoveryClient discoveryClient;

    // 注入一个接口实现类
    @Resource // 通过变量名进行注入
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-EUREKA-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
