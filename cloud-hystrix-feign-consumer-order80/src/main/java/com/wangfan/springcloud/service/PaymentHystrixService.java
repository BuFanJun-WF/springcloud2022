package com.wangfan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangfan
 * @Description
 * @date 2022/6/13 15:37:08
 */

@Service
@FeignClient(
        value = "CLOUD-HYSTRIX-PROVIDER-PAYMENT",
        fallback = PaymentFallbackService.class
)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
