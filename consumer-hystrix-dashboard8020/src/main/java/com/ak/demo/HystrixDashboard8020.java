/*
 * FileName: HystrixDashboard8020
 * Author:   Akeung
 * Date:     2020/8/8
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Akeung
 * 2020/8/8
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard8020 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard8020.class, args);
    }
}
