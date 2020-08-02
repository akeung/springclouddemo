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
import org.springframework.stereotype.Controller;
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

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果： {}",result);
        if(result>0){
            return new CommonResult<>(200, "插入数据成功",result);
        }
        return new CommonResult<>(444,"插入数据失败",result);
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果： {}",payment);
        if(payment != null){
            return new CommonResult<>(200,"查询数据结果",payment);
        }
        return new CommonResult<>(444,"查询数据为空",null);
    }
}
