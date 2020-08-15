/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: OrderMapper
 * Author:   Akeung
 * Date:     2020-08-14
 */
package com.ak.demo.mapper;

import com.ak.demo.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 * @author Akeung
 * 2020-08-14
 */
@Mapper
public interface OrderMapper {

    /**
     * 保存或更新
     * @param order 
     */
    void saveOrUpdate(@Param("order") Order order);

    void updateStatus(@Param("userId") Long userId,@Param("status") Integer status);
}