/*
 * FileName: PaymentService
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.service;

import com.ak.demo.entities.Payment;

/**
 * @author Akeung
 * 2020/8/2
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
