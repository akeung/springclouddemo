/*
 * FileName: PaymentServiceImpl
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.service.impl;

import com.ak.demo.dao.PaymentDao;
import com.ak.demo.entities.Payment;
import com.ak.demo.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Akeung
 * 2020/8/2
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
