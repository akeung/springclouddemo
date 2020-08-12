/*
 * FileName: AlibabaProvider8902
 * Author:   Akeung
 * Date:     2020/8/11
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Akeung
 * 2020/8/11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaProvider8902 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProvider8902.class, args);
    }
}
