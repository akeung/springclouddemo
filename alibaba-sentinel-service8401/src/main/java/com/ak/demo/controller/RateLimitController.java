/*
 * FileName: RateLimitController
 * Author:   Akeung
 * Date:     2020/8/13
 */
package com.ak.demo.controller;

import com.ak.demo.entities.CommonResult;
import com.ak.demo.entities.Payment;
import com.ak.demo.handler.CustomerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akeung
 * 2020/8/13
 */
@RestController
public class RateLimitController {
    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流 test ok", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按Url限流 test ok", new Payment(2020L, "serial002"));
    }

    @GetMapping("customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
    blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException1")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按自定义限流 test ok", new Payment(2020L, "serial003"));
    }
}
