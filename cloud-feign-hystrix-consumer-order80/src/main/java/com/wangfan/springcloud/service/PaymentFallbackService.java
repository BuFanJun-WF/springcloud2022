package com.wangfan.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName PaymentFallbackService
 * @Author wangfan
 * @Date 2022-05-08
 * @Description
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "------PaymentFallbackService fallback paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "------PaymentFallbackService fallback paymentInfoTimeout";
    }
}
