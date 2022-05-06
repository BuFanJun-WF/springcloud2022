package com.wangfan.springcloud.controller;

import com.wangfan.springcloud.entities.CommonResult;
import com.wangfan.springcloud.entities.Payment;
import com.wangfan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PaymentController
 * @Author wangfan
 * @Date 2022-05-05
 * @Description
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);

        if(result > 0) {
            return new CommonResult(200,"插入数据库成功,服务器端口号为：" + serverPort,result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询操作返回结果:" + payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功,服务器端口号为：" + serverPort, payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element :
                services) {
            log.info("******微服务内容:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-EUREKA-PAYMENT-SERVICE");
        for (ServiceInstance element:
                instances
             ) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }


}
