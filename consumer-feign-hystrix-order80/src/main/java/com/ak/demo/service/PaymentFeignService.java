/*
 * FileName: PaymentFeignService
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.service;

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

    @GetMapping("payment/paymentInfo_TimeOut/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
