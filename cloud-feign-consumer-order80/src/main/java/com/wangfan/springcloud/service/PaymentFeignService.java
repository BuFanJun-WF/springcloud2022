package com.wangfan.springcloud.service;

import com.wangfan.springcloud.entities.CommonResult;
import com.wangfan.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentFeignService
 * @Author wangfan
 * @Date 2022-05-06
 * @Description
 */
@Component
// CLOUD-EUREKA-PAYMENT-SERVICE
// 表示到名为cloud-eureka-payment-service的微服务上，可以获取
@FeignClient(value = "cloud-eureka-payment-service")
public interface PaymentFeignService {

    // 调用@GetMapping(value = "/payment/getPaymentById/{id}")的地址的方法
    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    /**
     * 测试超时程序接口
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();

}
