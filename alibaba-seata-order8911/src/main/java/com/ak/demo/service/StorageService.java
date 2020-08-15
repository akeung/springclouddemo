/*
 * FileName: StorageService
 * Author:   Akeung
 * Date:     2020/8/14
 */
package com.ak.demo.service;

import com.ak.demo.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Akeung
 * 2020/8/14
 */
@FeignClient(value = "seata-storage")
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
