/*
 * FileName: ApplicationContextConfig
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Akeung
 * 2020/8/2
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
