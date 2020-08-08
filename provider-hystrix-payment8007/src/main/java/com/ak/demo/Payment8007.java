/*
 * FileName: Payment8007
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Akeung
 * 2020/8/2
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class Payment8007 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8007.class,args);
    }
}
