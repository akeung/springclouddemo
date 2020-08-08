/*
 * FileName: OrderPaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.service.PaymentFeignService;
import com.ak.demo.service.PaymentFeignService2;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@Slf4j
@RestController
@RequestMapping("/order/payment")
public class OrderPaymentController {

    @Autowired
    private PaymentFeignService paymentFeignService;
    @Autowired
    private PaymentFeignService2 paymentFeignService2;

    @GetMapping("paymentInfo_TimeOut2/{id}")
    public String paymentInfo_TimeOut2(@PathVariable Integer id) {
        return paymentFeignService2.paymentInfo_TimeOut(id);
    }

    @GetMapping("paymentInfo_TimeOut/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable Integer id) {
        return paymentFeignService.paymentInfo_TimeOut(id);
    }

    private String paymentInfo_TimeOutHandler(Integer id) {
        return "OrderPayment 线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler,id:" + id + "\t";
    }

    private String payment_Global_FallbackMethod() {
        return "全局 线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler";
    }
}
