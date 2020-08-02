/*
 * FileName: OrderPaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Akeung
 * 2020/8/2
 */
@Slf4j
@RestController
@RequestMapping("/order/payment")
public class OrderPaymentController {

    private final static String PAYMENT_URL = "http://localhost:8001";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, CommonResult.class);
    }
}
