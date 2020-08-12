/*
 * FileName: EchoController
 * Author:   Akeung
 * Date:     2020/8/11
 */
package com.ak.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akeung
 * 2020/8/11
 */
@RestController
public class EchoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/echo")
    public String echo() {
        return "Hello Nacos Discovery: " + serverPort;
    }
}
