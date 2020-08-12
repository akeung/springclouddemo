/*
 * FileName: ConfigClientController
 * Author:   Akeung
 * Date:     2020/8/9
 */
package com.ak.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akeung
 * 2020/8/9
 */
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("config/info")
    public String getConfigInfo() {
        return configInfo+"\n serverPort:"+serverPort;
    }
}
