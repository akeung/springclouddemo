/*
 * FileName: PaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Payment;
import com.ak.demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        log.info("*******" + services);
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("******{},{},{},{}"
                    , instance.getHost(), instance.getPort(),
                    instance.getInstanceId(), instance.getServiceId());
        }
        return discoveryClient;
    }

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

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟 模拟超时任务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    @GetMapping(value = "/paymentInfo_TimeOut")
    public String paymentInfo_TimeOut() {
        try {
            // 暂停3秒钟 模拟超时任务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    private String paymentInfo_TimeOutHandler() {
        String serialNumber = IdUtil.simpleUUID();
        return " 流水号:" + serialNumber;
    }
}
