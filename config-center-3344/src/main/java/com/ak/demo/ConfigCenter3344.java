/*
 * FileName: ConfigCenter3344
 * Author:   Akeung
 * Date:     2020/8/9
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Akeung
 * 2020/8/9
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class,args);
    }
}
