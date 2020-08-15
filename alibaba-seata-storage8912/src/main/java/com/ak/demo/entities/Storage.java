/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: Storage
 * Author:   Akeung
 * Date:     2020-08-15
 */
package com.ak.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * entity
 * @author Akeung
 * 2020-08-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage  {

    private Long id;

	/**
	 * 产品id
	 */
    private Long productId;

	/**
	 * 总库存
	 */
    private Integer total;

	/**
	 * 已用库存
	 */
    private Integer used;

	/**
	 * 剩余库存
	 */
    private Integer residue;


}
