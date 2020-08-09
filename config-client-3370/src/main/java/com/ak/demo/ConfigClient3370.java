/*
 * FileName: ConfigClient3370
 * Author:   Akeung
 * Date:     2020/8/9
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Akeung
 * 2020/8/9
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3370 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3370.class,args);
    }
}
