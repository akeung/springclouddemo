/*
 * FileName: FeignService
 * Author:   Akeung
 * Date:     2020/8/7
 */
package com.ak.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Akeung
 * 2020/8/7
 */

@FeignClient(value = "alibaba-provider",fallback = FeignService.FeignServiceImpl.class)
public interface FeignService {

    @GetMapping("/echo")
    String echo();

    @Component
    class FeignServiceImpl implements  FeignService{

        @Override
        public String echo() {
            return "服务降级返回";
        }
    }
}
