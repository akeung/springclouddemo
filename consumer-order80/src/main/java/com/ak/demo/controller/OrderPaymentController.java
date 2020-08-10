/*
 * FileName: OrderPaymentController
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.controller;

import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Payment;
import com.ak.demo.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author Akeung
 * 2020/8/2
 */
@Slf4j
@RestController
@RequestMapping("/order/payment")
public class OrderPaymentController {

    private final static String PAYMENT_URL = "http://PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

//    @Autowired //todo 与 @LoadBalanced 互斥
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("get/LB")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        if (instances == null || instances.size() < 1) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/LB", String.class);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
