package com.wangfan.springcloud.controller;

import com.wangfan.springcloud.service.IMessagePovider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangfan
 * @Description
 * @date 2022/6/14 10:24:10
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessagePovider messagePovider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messagePovider.send();
    }
}
