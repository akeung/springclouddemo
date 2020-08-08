/*
 * FileName: HystrixTurbine8021
 * Author:   Akeung
 * Date:     2020/8/8
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Akeung
 * 2020/8/8
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixTurbine8021 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbine8021.class,args);
    }
}
