/*
 * FileName: EurekaServer7002
 * Author:   Akeung
 * Date:     2020/8/3
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Akeung
 * 2020/8/3
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class, args);
    }
}
