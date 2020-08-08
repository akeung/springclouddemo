/*
 * FileName: PaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Payment;
import com.ak.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果： {}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功 serverPort:" + serverPort, result);
        }
        return new CommonResult<>(444, "插入数据失败 serverPort:" + serverPort, result);
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果： {}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询数据结果 serverPort:" + serverPort, payment);
        }
        return new CommonResult<>(444, "查询数据为空serverPort:" + serverPort, null);
    }

    @GetMapping(value = {"get/LB","LB"})
    public String getPaymentLB() {
        return serverPort;
    }
}
