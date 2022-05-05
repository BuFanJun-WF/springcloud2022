package com.wangfan.springcloud.service;

import com.wangfan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */
public interface PaymentService {
    /**
     * 创建支付订单
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 和PaymentDao的方法中相同。
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);

}
