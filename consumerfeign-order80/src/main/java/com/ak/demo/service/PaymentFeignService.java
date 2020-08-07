/*
 * FileName: PaymentFeignService
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.service;

import com.ak.demo.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Akeung
 * 2020/8/7
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
