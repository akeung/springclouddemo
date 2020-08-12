/*
 * FileName: AlibabaProvider8901
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
public class AlibabaProvider8901 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProvider8901.class, args);
    }
}
