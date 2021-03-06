/*
 * FileName: Order80
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo;

import com.ak.irule.config.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Akeung
 * 2020/8/2
 */
@RibbonClient(name = "PAYMENT-SERVICE",configuration = RibbonRule.class)
@EnableEurekaClient
@SpringBootApplication
public class Order80 {
    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
