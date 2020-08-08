/*
 * FileName: PaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akeung
 * 2020/8/2
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("paymentInfo_TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id) {
        return paymentService.paymentInfo_TimeOut(id);
    }

    @GetMapping("paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
