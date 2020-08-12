/*
 * FileName: EchoController
 * Author:   Akeung
 * Date:     2020/8/11
 */
package com.ak.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Akeung
 * 2020/8/11
 */
@RestController
public class EchoController {
    private final static String PAYMENT_URL = "http://alibaba-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/echo")
    public String echo() {
        return restTemplate.getForObject(PAYMENT_URL + "/echo", String.class);
    }
}
