/*
 * FileName: PaymentFeignService
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Akeung
 * 2020/8/7
 */
@Primary
@FeignClient(value = "PAYMENT-SERVICE2",fallback = PaymentFeignService2.PaymentFeignService2FallBack.class)//模拟不存在的服务，宕机
public interface PaymentFeignService2 {

    @GetMapping("payment/paymentInfo_TimeOut/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

    @Component
    class PaymentFeignService2FallBack implements PaymentFeignService2{

        @Override
        public String paymentInfo_TimeOut(Integer id) {
            return "PAYMENT-SERVICE2 宕机";
        }
    }
}
