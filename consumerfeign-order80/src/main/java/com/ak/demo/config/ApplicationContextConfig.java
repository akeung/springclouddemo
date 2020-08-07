/*
 * FileName: ApplicationContextConfig
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Akeung
 * 2020/8/2
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public Logger.Level logger(){
       return Logger.Level.FULL;
//       return Logger.Level.BASIC;
    }
}
