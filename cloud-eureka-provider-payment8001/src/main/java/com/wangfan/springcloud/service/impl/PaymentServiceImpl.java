package com.wangfan.springcloud.service.impl;


import com.wangfan.springcloud.entities.Payment;

import com.wangfan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import com.wangfan.springcloud.dao.PaymentDao;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 注解中@Resource和@Autowired注解都是用来实现依赖注入的。
     * 只是@AutoWried按by type自动注入，而@Resource默认按byName自动注入。
     */
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
