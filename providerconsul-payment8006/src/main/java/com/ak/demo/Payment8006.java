/*
 * FileName: Payment8006
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Akeung
 * 2020/8/2
 */
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
public class Payment8006 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8006.class,args);
    }
}
