/*
 * FileName: Payment8002
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Akeung
 * 2020/8/2
 */
@EnableEurekaClient
@SpringBootApplication
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class,args);
    }
}
