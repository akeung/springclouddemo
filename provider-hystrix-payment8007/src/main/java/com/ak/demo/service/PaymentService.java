/*
 * FileName: PaymentService
 * Author:   Akeung
 * Date:     2020/8/2
 */
package com.ak.demo.service;

/**
 * @author Akeung
 * 2020/8/2
 */
public interface PaymentService {
     String paymentInfo_TimeOut(Integer id);
     String paymentCircuitBreaker(Integer id);
}
