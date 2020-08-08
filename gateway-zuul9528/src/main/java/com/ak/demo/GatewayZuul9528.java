/*
 * FileName: GatewayZuul9528
 * Author:   Akeung
 * Date:     2020/8/8
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Akeung
 * 2020/8/8
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class GatewayZuul9528 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuul9528.class,args);
    }
}
