/*
 * FileName: PaymentDao
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.dao;

import com.ak.demo.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Akeung
 * 2020/8/2
 */
@Mapper
public interface PaymentDao {
   int create(Payment payment);
   Payment getPaymentById(@Param("id") Long id);
}
