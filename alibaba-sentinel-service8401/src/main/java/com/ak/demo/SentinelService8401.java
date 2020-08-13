/*
 * FileName: SentinelService8401
 * Author:   Akeung
 * Date:     2020/8/13
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Akeung
 * 2020/8/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401.class,args);
    }
}
