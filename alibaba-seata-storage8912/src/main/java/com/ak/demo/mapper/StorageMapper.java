/*
 * Copyright (C), 2020-2020, Akeung
 * FileName: StorageMapper
 * Author:   Akeung
 * Date:     2020-08-15
 */
package com.ak.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author Akeung
 * 2020-08-15
 */
@Mapper
public interface StorageMapper {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}