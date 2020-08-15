/*
 * FileName: AccountService
 * Author:   Akeung
 * Date:     2020/8/14
 */
package com.ak.demo.service;

import com.ak.demo.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Akeung
 * 2020/8/14
 */
@FeignClient(value = "seata-account")
public interface AccountService {
    /**
     * 扣减账户金额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
