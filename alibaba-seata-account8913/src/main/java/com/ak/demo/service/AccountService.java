/*
 * FileName: AccountService
 * Author:   Akeung
 * Date:     2020/8/14
 */
package com.ak.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Akeung
 * 2020/8/14
 */
@Service
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
