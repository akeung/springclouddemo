/*
 * FileName: Stream8803
 * Author:   Akeung
 * Date:     2020/8/10
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Akeung
 * 2020/8/10
 */
@EnableEurekaClient
@SpringBootApplication
public class Stream8803 {
    public static void main(String[] args) {
        SpringApplication.run(Stream8803.class,args);
    }
}
