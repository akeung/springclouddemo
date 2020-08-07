/*
 * FileName: OrderOpenFeign80
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Akeung
 * 2020/8/7
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class OrderOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeign80.class,args);
    }
}
