package com.wangfan.springcloud.dao;

import com.wangfan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDap
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@Mapper
public interface PaymentDao {
    /**
     * 创建支付订单
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 通过订单id获取订单内容
     * 解释：在mapper.xml中采用#{}的方式把@Param注解括号内的参数进行引用
     * 作用：1.便于传多个参数，不使用@Param注解时，参数只能有一个，而且是JavaBean，在sql中只能引用JavaBean的属性。
     *      2.别名的功能
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);

}
