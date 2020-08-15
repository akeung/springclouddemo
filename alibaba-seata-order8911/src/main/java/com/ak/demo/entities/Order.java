/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: Order
 * Author:   Akeung
 * Date:     2020-08-14
 */
package com.ak.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * entity
 * @author Akeung
 * 2020-08-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order  {

    private Long id;

	/**
	 * 用户id
	 */
    private Long userId;

	/**
	 * 产品id
	 */
    private Long productId;

	/**
	 * 数量
	 */
    private Integer count;

	/**
	 * 金额
	 */
    private BigDecimal money;

	/**
	 * 订单状态: 0:创建中:1:已完结
	 */
    private Integer status;


}
