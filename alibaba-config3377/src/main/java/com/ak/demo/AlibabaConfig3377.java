/*
 * FileName: AlibabaConfig3377
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
public class AlibabaConfig3377 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConfig3377.class,args);
    }
}
