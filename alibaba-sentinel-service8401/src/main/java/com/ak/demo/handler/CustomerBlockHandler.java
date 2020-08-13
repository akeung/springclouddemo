/*
 * FileName: CustomerBlockHandler
 * Author:   Akeung
 * Date:     2020/8/13
 */
package com.ak.demo.handler;

import com.ak.demo.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author Akeung
 * 2020/8/13
 */
public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(444, "自定义的限流处理信息 CustomerBlockHandler handleException1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "自定义的限流处理信息 CustomerBlockHandler handleException2");
    }
}

