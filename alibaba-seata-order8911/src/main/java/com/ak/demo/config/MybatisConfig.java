/*
 * FileName: MybatisConfig
 * Author:   Akeung
 * Date:     2020/8/15
 */
package com.ak.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Akeung
 * 2020/8/15
 */
@Configuration
@MapperScan({"com.ak.demo.mapper"})
public class MybatisConfig {
}
