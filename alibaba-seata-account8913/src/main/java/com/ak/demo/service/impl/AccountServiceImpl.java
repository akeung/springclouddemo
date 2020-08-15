/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: AccountServiceImpl
 * Author:   Akeung
 * Date:     2020-08-14
 */
package com.ak.demo.service.impl;

import com.ak.demo.mapper.AccountMapper;
import com.ak.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * service
 *
 * @author Akeung
 * 2020-08-14
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("seata-account##decrease account start=======");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountMapper.decrease(userId,money);
        log.info("seata-account##end");
    }
}
