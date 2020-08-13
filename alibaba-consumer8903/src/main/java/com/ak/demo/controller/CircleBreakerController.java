/*
 * FileName: CircleBreakerController
 * Author:   Akeung
 * Date:     2020/8/13
 */
package com.ak.demo.controller;

import com.ak.demo.service.FeignService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Akeung
 * 2020/8/13
 */
@RestController
public class CircleBreakerController {
    private final static String PAYMENT_URL = "http://alibaba-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//没有配置处理
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//配置fallback处理,fallback管运行异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//配置blockHandler处理,blockHandler管配置违规,异常还是错误页面
    //配置fallback处理、blockHandler处理：
    //若blockHandler和fallback都进行了配置,
    //则被限流降级而抛出BlockException时只会进入BlockHandler处理逻辑
//    @SentinelResource(value = "fallback",
//            fallback = "handlerFallback",
//            blockHandler = "blockHandler")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = IllegalArgumentException.class)//出现异常 IllegalArgumentException,不走 handlerFallback
    public String echo(@PathVariable Long id) {
        if (id==500){
            throw new IllegalArgumentException("非法参数");
        }
        return restTemplate.getForObject(PAYMENT_URL + "/echo", String.class);
    }
    public String handlerFallback(@PathVariable Long id,Throwable e) {
        return "handlerFallback:"+id+" massage:"+e.getMessage();
    }
    public String blockHandler(@PathVariable Long id, BlockException e) {
        return "blockHandler:"+id+" massage:"+e.getMessage();
    }

    @Resource
    private FeignService feignService;

    @GetMapping("feign/echo")
   public String echo(){
        return feignService.echo();
    }

}
