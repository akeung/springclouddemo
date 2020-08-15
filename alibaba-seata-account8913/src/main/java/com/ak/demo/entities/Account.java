/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: Account
 * Author:   Akeung
 * Date:     2020-08-15
 */
package com.ak.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * entity
 * @author Akeung
 * 2020-08-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account  {

    private Long id;

	/**
	 * 用户id
	 */
    private Long userId;

	/**
	 * 总额度
	 */
    private BigDecimal total;

	/**
	 * 已用余额
	 */
    private BigDecimal used;

	/**
	 * 剩余可用额度
	 */
    private BigDecimal residue;


}
