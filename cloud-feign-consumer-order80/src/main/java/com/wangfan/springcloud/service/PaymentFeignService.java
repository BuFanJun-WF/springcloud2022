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
@FeignClient(value = "cloud-eureka-payment-service")
// 表示去名为cloud-eureka-payment-service的微服务上
// 调用@GetMapping(value = "/payment/get/{id}")的地址的方法
public interface PaymentFeignService {


    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
