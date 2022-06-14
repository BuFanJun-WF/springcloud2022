package com.wangfan.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangfan
 * @Description
 * @date 2022/6/14 10:00:08
 */

@EnableBinding(Source.class) // 可以理解为一个消息的发送管道的定义
public class MessqgeProviderImpl implements IMessagePovider{

    // 消息的发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build()); // 创建并发送消息
        System.out.println("***serial: "+serial);
        return serial;
    }
}
