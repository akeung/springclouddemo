/*
 * FileName: SeataAccount8913
 * Author:   Akeung
 * Date:     2020/8/14
 */
package com.ak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Akeung
 * 2020/8/14
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccount8913 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccount8913.class,args);
    }
}
