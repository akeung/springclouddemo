/*
 * FileName: RibbonRule
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Akeung
 * 2020/8/7
 */
//@Configuration
public class RibbonRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
