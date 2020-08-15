/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: AccountMapper
 * Author:   Akeung
 * Date:     2020-08-15
 */
package com.ak.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Mapper
 *
 * @author Akeung
 * 2020-08-15
 */
@Mapper
public interface AccountMapper {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}