package com.wangfan.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangfan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentServiceImpl
 * @Author wangfan
 * @Date 2022-05-07
 * @Description
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 测试正常成功
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+" paymentInfoOk;id: "+id+"\t";
    }

    //=============服务降价====================
    /**
     * 设置了两个异常,第一个为注解中的等待超过5秒异常，第二个为除0异常
     * @param id
     * @return
     */
    @Override
    // 开启Hystrix的降级回调
    @HystrixCommand(
            // 降级返回函数
            fallbackMethod = "paymentInfoTimeoutHandler",
            // 异常的情况
            commandProperties = {
                // 超时时间为3秒钟
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            }
    )
    public String paymentInfoTimeOut(Integer id) {
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+" paymentTimeOut;id: "+id+"\t"+" 耗时（5秒钟）"+time+"s";
    }
    // 作为出现异常时的降级回调函数
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+" paymentInfoTimeoutHandler;id: "+id+"\t"+"进入了报错处理";
    }

    //===============服务熔断===========
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        // IdUtil.simpleUUID()相当于UUID.randomUUID().toString()
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
