package com.wangfan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wangfan
 * @Description
 * @date 2022/6/13 16:37:18
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "=====PaymentFallbackService fall back-paymentInfo_OK, 服务失败";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "=====PaymentFallbackService fall back-paymentInfo_TimeOut, 服务失败";
    }
}
