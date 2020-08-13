/*
 * FileName: FlowLimitController
 * Author:   Akeung
 * Date:     2020/8/13
 */
package com.ak.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Akeung
 * 2020/8/13
 */
@Slf4j
@RestController
public class FlowLimitController {
    @GetMapping("testA")
    public String testA() {
        return "===testA";
    }

    @GetMapping("testB")
    public String testB() {
        log.info("-----------testB------------");
        return "===testB";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        return "testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception){
        return "dealTestHotKey";//sentinel默认提示：Blocked by Sentinel (flow limiting)
    }

}
