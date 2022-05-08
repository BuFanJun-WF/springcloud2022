package com.wangfan.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Author wangfan
 * @Date 2022-05-07
 * @Description
 */
public interface PaymentService {
    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id);

    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    public String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
