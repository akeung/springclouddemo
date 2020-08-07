/*
 * FileName: OrderPaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.entities.CommonResult;
import com.ak.demo.service.PaymentFeignService;
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
@RequestMapping("/order/payment")
public class OrderPaymentController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
