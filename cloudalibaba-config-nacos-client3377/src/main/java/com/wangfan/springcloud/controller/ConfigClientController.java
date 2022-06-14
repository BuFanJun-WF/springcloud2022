package com.wangfan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Author wangfan
 * @Date 2022-05-10
 * @Description @RefreshScope表示 在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * 表示在Nacos配置环境中，获取里面的配置文件别中设置有的"${config.info}"
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
